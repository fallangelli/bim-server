package com.family.grabserver.pipeline;

import com.family.grab.Task;
import com.family.grab.pipeline.PageModelPipeline;
import com.family.grabserver.dao.MaoyanCinemaDao;
import com.family.grabserver.model.MaoyanCinemaJson;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午8:56
 */
@Component("MaoyanCinemaJsonPipeline")
public class MaoyanCinemaJsonPipeline implements PageModelPipeline<MaoyanCinemaJson> {

    @Resource
    private MaoyanCinemaDao dao;

    @Override
    public void process(MaoyanCinemaJson monyanCinemaJson, Task task) {
//        String context = monyanCinemaJson.getContext();

        dao.add(monyanCinemaJson);
    }
}