package com.family.grab.pipeline;

import com.alibaba.fastjson.JSON;
import com.family.grab.Task;
import com.family.grab.model.HasKey;
import com.family.grab.utils.FilePersistentBase;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Store results objects (page models) to files in JSON format.<br>
 * Use com.family.grabserver.model.getKey() as file name if the com.family.grabserver.model implements HasKey.<br>
 * Otherwise use SHA1 as file name.
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.2.0
 */
public class JsonFilePageModelPipeline extends FilePersistentBase implements PageModelPipeline {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * new JsonFilePageModelPipeline with default path "/data/grab/"
     */
    public JsonFilePageModelPipeline() {
        setPath("/data/grab/");
    }

    public JsonFilePageModelPipeline(String path) {
        setPath(path);
    }

    @Override
    public void process(Object o, Task task) {
        String path = this.path + PATH_SEPERATOR + task.getUUID() + PATH_SEPERATOR;
        try {
            String filename;
            if (o instanceof HasKey) {
                filename = path + ((HasKey) o).key() + ".json";
            } else {
                filename = path + DigestUtils.md5Hex(ToStringBuilder.reflectionToString(o)) + ".json";
            }
            PrintWriter printWriter = new PrintWriter(new FileWriter(getFile(filename)));
            printWriter.write(JSON.toJSONString(o));
            printWriter.close();
        } catch (IOException e) {
            logger.warn("write file error", e);
        }
    }
}