package com.family.grabserver.crawler.mtime;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grabserver.model.mtime.CityMtimeModel;
import com.family.grabserver.pipeline.mtime.CityMtimePipeline;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CityMtimeCrawler {
    @Autowired
    private CityMtimePipeline pipeline;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final CityMtimeCrawler jsonCrawler = applicationContext.getBean(CityMtimeCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {
        logger.info("开始抓取 时光 城市列表");

        OOSpider.create(Site.me().setRetryTimes(5).setRetrySleepTime(3000),
                pipeline, CityMtimeModel.class)
                .addUrl("http://m.mtime.cn/Service/callback.mi/Showtime/HotCitiesByCinema.api")
                .thread(1).run();
    }
}
