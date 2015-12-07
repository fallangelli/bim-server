package com.family.grabserver.crawler.mtime;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grabserver.entity.CinemaMtime;
import com.family.grabserver.model.mtime.CinemamovieMtimeModel;
import com.family.grabserver.pipeline.mtime.CinemamoiveMtimePipeline;
import com.family.grabserver.service.CinemaMtimeService;
import com.family.grabserver.util.SqlUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CinemamovieMtimeCrawler {
    @Autowired
    private CinemamoiveMtimePipeline pipeline;

    @Autowired
    private CinemaMtimeService cinemaService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final CinemamovieMtimeCrawler jsonCrawler = applicationContext.getBean(CinemamovieMtimeCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {
        try {
            SqlUtil.deleteAll("cinemamovie_Mtime");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        List<CinemaMtime> allCinema = cinemaService.selectAll();
        List<String> urls = new ArrayList<>();
        for (CinemaMtime cinema : allCinema) {
            String url = "http://m.mtime.cn/Service/callback.mi/Showtime/ShowtimeMovieAndDateListByCinema.api?cinemaId=" + cinema.getId();
            urls.add(url);
        }
        logger.info("开始抓取 时光 影院上映电影");
        OOSpider.create(Site.me().setTimeOut(30000).setSleepTime(500).setCycleRetryTimes(5).setRetrySleepTime(1000),
                pipeline, CinemamovieMtimeModel.class).addUrl((String[]) urls.toArray(new String[]{}))
                .thread(100).run();
    }
}
