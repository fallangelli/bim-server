package com.family.grabserver.crawler;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grab.pipeline.ConsolePipeline;
import com.family.grabserver.model.MaoyanCinemaJson;
import com.family.grabserver.pipeline.MaoyanCinemaJsonPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class JsonCrawler {
    @Qualifier("MaoyanCinemaJsonPipeline")
    @Autowired
    private MaoyanCinemaJsonPipeline maoyanCinemaJsonPipeline;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final JsonCrawler jsonCrawler = applicationContext.getBean(JsonCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {
        OOSpider.create(Site.me(),
                maoyanCinemaJsonPipeline, MaoyanCinemaJson.class).addUrl("http://m.maoyan.com/showtime/wrap.json?cinemaid=153")
                .addPipeline(new ConsolePipeline()).thread(5).run();
    }
}
