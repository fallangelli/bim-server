package com.family.grabserver.crawler.maoyan;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grabserver.entity.CityMaoyan;
import com.family.grabserver.model.maoyan.CinemaMaoyanModel;
import com.family.grabserver.pipeline.maoyan.CinemaMaoyanPipeline;
import com.family.grabserver.service.CityMaoyanService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CinemaMaoyanCrawler {
    @Autowired
    private CinemaMaoyanPipeline cinemaMaoyanPipeline;

    @Autowired
    private CityMaoyanService cityService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final CinemaMaoyanCrawler jsonCrawler = applicationContext.getBean(CinemaMaoyanCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {

        List<CityMaoyan> allCity = cityService.selectAll();

        for (CityMaoyan city : allCity) {
            logger.info("开始抓取猫眼影院信息 -  " + city.getName());

            String url = "http://m.maoyan.com/cinemas.json?cityId="
                    + city.getId() + "&cityName=" + city.getName();

            OOSpider.create(Site.me().setRetryTimes(5).setRetrySleepTime(3000)
                            .addCookie("ci", city.getId().toString()),
                    cinemaMaoyanPipeline, CinemaMaoyanModel.class)
                    .addUrl(url)
                    .thread(1).run();


        }


    }
}
