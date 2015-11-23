package com.family.grabserver.pipeline;

import com.family.grabserver.dao.ComingDao;
import com.family.grabserver.model.DoubanComing;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午8:56
 */
@Component("DoubanComingPipeline")
public class DoubanComingPipeline implements PageModelPipeline<DoubanComing> {

    @Resource
    private ComingDao dao;

    @Override
    public void process(DoubanComing doubanComing, Task task) {
        dao.add(doubanComing);
    }
}