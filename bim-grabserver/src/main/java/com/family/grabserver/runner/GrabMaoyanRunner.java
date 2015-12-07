package com.family.grabserver.runner;

import com.family.grabserver.crawler.maoyan.CinemaMaoyanCrawler;
import com.family.grabserver.crawler.maoyan.CinemamovieMaoyanCrawler;
import com.family.grabserver.crawler.maoyan.CityMaoyanCrawler;
import com.family.grabserver.crawler.maoyan.ShowplanMaoyanCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GrabMaoyanRunner {
    @Autowired
    public CityMaoyanCrawler cityCrawler;
    @Autowired
    public CinemaMaoyanCrawler cinemaCrawler;
    @Autowired
    public CinemamovieMaoyanCrawler cmCrawler;
    @Autowired
    public ShowplanMaoyanCrawler showCrawler;


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final GrabMaoyanRunner grabMaoyanRunner = applicationContext.getBean(GrabMaoyanRunner.class);
        grabMaoyanRunner.cityCrawler.crawl();
        grabMaoyanRunner.cinemaCrawler.crawl();
        grabMaoyanRunner.cmCrawler.crawl();
        grabMaoyanRunner.showCrawler.crawl();
    }
}