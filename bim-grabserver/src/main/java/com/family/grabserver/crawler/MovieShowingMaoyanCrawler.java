package com.family.grabserver.crawler;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grab.pipeline.ConsolePipeline;
import com.family.grabserver.entity.CityMaoyan;
import com.family.grabserver.model.MovieShowingMaoyanModel;
import com.family.grabserver.pipeline.MovieShowingMaoyanPipeline;
import com.family.grabserver.service.CityMaoyanService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieShowingMaoyanCrawler {
    @Autowired
    private MovieShowingMaoyanPipeline movieShowingMaoyanPipeline;

    @Autowired
    private CityMaoyanService cityService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final MovieShowingMaoyanCrawler jsonCrawler = applicationContext.getBean(MovieShowingMaoyanCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {
        List<CityMaoyan> allCity = cityService.selectAll();
        for (CityMaoyan city : allCity) {
            logger.info("start getting movie from maoyan in " + city.getName());

            OOSpider.create(Site.me().setRetryTimes(2).addCookie("ci", city.getId().toString()),
                    movieShowingMaoyanPipeline, MovieShowingMaoyanModel.class).addUrl("http://m.maoyan.com/movie/list.json")
                    .addPipeline(new ConsolePipeline()).thread(1).run();
        }
    }
}
