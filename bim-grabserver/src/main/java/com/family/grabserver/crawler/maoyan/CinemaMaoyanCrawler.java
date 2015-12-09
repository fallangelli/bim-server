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

        logger.info("开始抓取 猫眼 影院信息");

        for (CityMaoyan city : allCity) {
            String url = "http://m.maoyan.com/cinemas.json?cityId="
                    + city.getId();

            CinemaMaoyanCrawler.CinemaThread th = new CinemaThread(cinemaMaoyanPipeline, city.getId(), url);
            pool.execute(th);
        }
        pool.shutdown();
        try {//等待直到所有任务完成
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("完成抓取 猫眼 影院信息");

    }


    public class CinemaThread implements Runnable {
        CinemaMaoyanPipeline cinemaMaoyanPipeline;
        Integer cityId;
        String url;

        public CinemaThread(CinemaMaoyanPipeline cinemaMaoyanPipeline, Integer cityId, String url) {
            this.cinemaMaoyanPipeline = cinemaMaoyanPipeline;
            this.cityId = cityId;
            this.url = url;
        }

        @Override
        public void run() {
            OOSpider.create(Site.me().setTimeOut(30000).setSleepTime(500).setCycleRetryTimes(5).setRetrySleepTime(3000)
                            .addCookie("ci", cityId.toString()),
                    cinemaMaoyanPipeline, CinemaMaoyanModel.class)
                    .addUrl(url)
                    .thread(1).run();
        }

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public CinemaMaoyanPipeline getCinemaMaoyanPipeline() {
            return cinemaMaoyanPipeline;
        }

        public void setCinemaMaoyanPipeline(CinemaMaoyanPipeline cinemaMaoyanPipeline) {
            this.cinemaMaoyanPipeline = cinemaMaoyanPipeline;
        }

    }

}
