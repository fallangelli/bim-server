package com.family.grabserver.crawler;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grab.pipeline.ConsolePipeline;
import com.family.grabserver.entity.CinemaMaoyan;
import com.family.grabserver.model.CinemaMovieMaoyanModel;
import com.family.grabserver.pipeline.CinemaMoiveMaoyanPipeline;
import com.family.grabserver.service.CinemaMaoyanService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CinemaMovieMaoyanCrawler {
    @Autowired
    private CinemaMoiveMaoyanPipeline pipeline;

    @Autowired
    private CinemaMaoyanService cinemaService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final CinemaMovieMaoyanCrawler jsonCrawler = applicationContext.getBean(CinemaMovieMaoyanCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {
        List<CinemaMaoyan> allCinema = cinemaService.selectAll();
        for (CinemaMaoyan cinema : allCinema) {
            logger.info("start getting movies from maoyan in " + cinema.getNm());
            pipeline.setCinemaId(cinema.getId());
            String url = "http://m.maoyan.com/showtime/wrap.json?cinemaid=" + cinema.getId();
            OOSpider.create(Site.me(),
                    pipeline, CinemaMovieMaoyanModel.class).addUrl(url)
                    .addPipeline(new ConsolePipeline()).thread(1).run();
        }
    }
}
