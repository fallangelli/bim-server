package com.family.grabserver.runner;

import com.family.grabserver.crawler.maoyan.CinemaMaoyanCrawler;
import com.family.grabserver.crawler.maoyan.CinemamovieMaoyanCrawler;
import com.family.grabserver.crawler.maoyan.CityMaoyanCrawler;
import com.family.grabserver.crawler.maoyan.ShowplanMaoyanCrawler;
import com.family.grabserver.crawler.mtime.CinemaMtimeCrawler;
import com.family.grabserver.crawler.mtime.CinemamovieMtimeCrawler;
import com.family.grabserver.crawler.mtime.CityMtimeCrawler;
import com.family.grabserver.crawler.mtime.ShowplanMtimeCrawler;
import com.family.grabserver.service.MergeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainRunner {

    @Autowired
    public CityMaoyanCrawler cityMaoyanCrawler;
    @Autowired
    public CinemaMaoyanCrawler cinemaMaoyanCrawler;
    @Autowired
    public CinemamovieMaoyanCrawler cinemamovieMaoyanCrawler;
    @Autowired
    public ShowplanMaoyanCrawler showplanMaoyanCrawler;


    @Autowired
    public CityMtimeCrawler cityMtimeCrawler;
    @Autowired
    public CinemaMtimeCrawler cinemaMtimeCrawler;
    @Autowired
    public CinemamovieMtimeCrawler cinemamovieMtimeCrawler;
    @Autowired
    public ShowplanMtimeCrawler showplanMtimeCrawler;

    @Autowired
    public MergeService mergeService;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final MainRunner grabMaoyanRunner = applicationContext.getBean(MainRunner.class);
        grabMaoyanRunner.grabCity();
        grabMaoyanRunner.grabCinema();
        grabMaoyanRunner.grabCinemamovie();
        grabMaoyanRunner.grabShowplan();
        grabMaoyanRunner.mergeService.merge();
    }

    public void grabCity() {
        cityMaoyanCrawler.crawl();
        cityMtimeCrawler.crawl();
    }


    public void grabCinema() {
        cinemaMaoyanCrawler.crawl();
        cinemaMaoyanCrawler.crawl();
    }

    public void grabCinemamovie() {
        cinemamovieMaoyanCrawler.crawl();
        cinemamovieMtimeCrawler.crawl();
    }

    public void grabShowplan() {
        showplanMaoyanCrawler.crawl();
        showplanMtimeCrawler.crawl();
    }

}