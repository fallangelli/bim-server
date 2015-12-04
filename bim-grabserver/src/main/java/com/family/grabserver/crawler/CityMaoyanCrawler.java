package com.family.grabserver.crawler;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grab.pipeline.ConsolePipeline;
import com.family.grabserver.model.CityMaoyanModel;
import com.family.grabserver.pipeline.CityMaoyanPipeline;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CityMaoyanCrawler {
    @Autowired
    private CityMaoyanPipeline CityMaoyanPipeline;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final CityMaoyanCrawler jsonCrawler = applicationContext.getBean(CityMaoyanCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {
        logger.info("start getting cities from maoyan");

        OOSpider.create(Site.me().setRetryTimes(2),
                CityMaoyanPipeline, CityMaoyanModel.class).addUrl("http://m.maoyan.com/changecity.json")
                .addPipeline(new ConsolePipeline()).thread(1).run();
    }
}
