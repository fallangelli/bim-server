package com.family.grabserver.crawler.mtime;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grabserver.entity.CityMtime;
import com.family.grabserver.model.mtime.CinemaMtimeModel;
import com.family.grabserver.pipeline.mtime.CinemaMtimePipeline;
import com.family.grabserver.service.CityMtimeService;
import com.sun.xml.internal.fastinfoset.util.StringArray;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CinemaMtimeCrawler {
    @Autowired
    private CinemaMtimePipeline cinemaMtimePipeline;

    @Autowired
    private CityMtimeService cityService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final CinemaMtimeCrawler jsonCrawler = applicationContext.getBean(CinemaMtimeCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {

        List<CityMtime> allCity = cityService.selectAll();

        StringArray urls = new StringArray();
        for (CityMtime city : allCity) {
            urls.add("http://m.mtime.cn/Service/callback.mi/" +
                    "OnlineLocationCinema/OnlineCinemasByCity.api?locationId=" + city.getId());
        }
        logger.info("开始抓取 时光 影院信息");
        OOSpider.create(Site.me().setRetryTimes(5).setRetrySleepTime(3000),
                cinemaMtimePipeline, CinemaMtimeModel.class)
                .addUrl(urls.getArray())
                .thread(50).run();

    }
}
