package com.family.grabserver.crawler.maoyan;

import com.family.grabserver.entity.CityMaoyan;
import com.family.grabserver.pipeline.maoyan.CinemaMaoyanPipeline;
import com.family.grabserver.service.CityMaoyanService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        ExecutorService pool = Executors.newFixedThreadPool(30);


        List<CityMaoyan> allCity = cityService.selectAll();

        for (CityMaoyan city : allCity) {
            logger.info("开始抓取猫眼影院信息 -  " + city.getName());

            String url = "http://m.maoyan.com/cinemas.json?cityId="
                    + city.getId();

            CinemaThread th = new CinemaThread(cinemaMaoyanPipeline, city.getId(), url);
            pool.execute(th);
        }
        pool.shutdown();
        try {//等待直到所有任务完成
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("完成抓取猫眼影院信息");

    }

}
