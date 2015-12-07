package com.family.grabserver.crawler.maoyan;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grabserver.entity.CinemaMaoyan;
import com.family.grabserver.model.maoyan.CinemaMaoyanModel;
import com.family.grabserver.model.maoyan.CinemamovieMaoyanModel;
import com.family.grabserver.pipeline.maoyan.CinemaMaoyanPipeline;
import com.family.grabserver.pipeline.maoyan.CinemamoiveMaoyanPipeline;
import com.family.grabserver.service.CinemaMaoyanService;
import com.family.grabserver.util.SqlUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CinemamovieMaoyanCrawler {
    @Autowired
    private CinemamoiveMaoyanPipeline pipeline;

    @Autowired
    private CinemaMaoyanService cinemaService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final CinemamovieMaoyanCrawler jsonCrawler = applicationContext.getBean(CinemamovieMaoyanCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {
        try {
            SqlUtil.deleteAll("cinemamovie_maoyan");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        List<CinemaMaoyan> allCinema = cinemaService.selectAll();
        List<String> urls = new ArrayList<String>();
        for (CinemaMaoyan cinema : allCinema) {
            String url = "http://m.maoyan.com/showtime/wrap.json?cinemaid=" + cinema.getId();
            urls.add(url);
        }
        logger.info("开始抓取影院上映电影");
        OOSpider.create(Site.me().setTimeOut(30000).setSleepTime(500).setCycleRetryTimes(5).setRetrySleepTime(1000),
                pipeline, CinemamovieMaoyanModel.class).addUrl((String[]) urls.toArray(new String[]{}))
                .thread(100).run();
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
