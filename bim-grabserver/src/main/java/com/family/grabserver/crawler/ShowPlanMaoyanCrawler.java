package com.family.grabserver.crawler;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grab.pipeline.ConsolePipeline;
import com.family.grabserver.entity.CinemaMovieMaoyan;
import com.family.grabserver.model.ShowPlanMaoyanModel;
import com.family.grabserver.pipeline.ShowPlanMaoyanPipeline;
import com.family.grabserver.service.CinemaMovieMaoyanService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowPlanMaoyanCrawler {
    @Autowired
    private ShowPlanMaoyanPipeline pipeline;

    @Autowired
    private CinemaMovieMaoyanService service;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final ShowPlanMaoyanCrawler jsonCrawler = applicationContext.getBean(ShowPlanMaoyanCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {
        List<CinemaMovieMaoyan> allCinemaMoive = service.selectAll();
        for (CinemaMovieMaoyan item : allCinemaMoive) {
            logger.info("start getting moive " + item.getMovieId() + " show plan from maoyan in " + item.getCinemaId());
            pipeline.setCinemaId(item.getCinemaId());
            pipeline.setMovieId(item.getMovieId());
            String url = "http://m.maoyan.com/showtime/wrap.json?cinemaid=" + item.getCinemaId() + "&movieid=" + item.getMovieId();
            OOSpider.create(Site.me().addCookie("ci", "1")
                            .addCookie("__mta", "251941430.1449133522188.1449133522188.1449133522188.1")
                            .addCookie("__utma", "17099173.248164319.1449133508.1449133508.1449133508.1")
                            .addCookie("__utmb", "17099173.4.9.1449133578034")
                            .addCookie("__utmc", "17099173")
                            .addCookie("__utmz", "17099173.1449133508.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)")
                            .addCookie("isWebp", "1")
                            .addCookie("JSESSIONID", "rebtpr4dhitcyihnfhujb8d7")
                            .addCookie("iuuid", "00F0BDA0B294FDA539775C4233D05C72F76D27F34E495DD051095F3AEBFF051D"),
                    pipeline, ShowPlanMaoyanModel.class).addUrl(url)
                    .addPipeline(new ConsolePipeline()).thread(1).run();
        }
    }
}
