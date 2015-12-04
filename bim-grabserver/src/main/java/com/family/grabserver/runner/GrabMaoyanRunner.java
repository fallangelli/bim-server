package com.family.grabserver.runner;

import com.family.grabserver.crawler.CinemaMaoyanCrawler;
import com.family.grabserver.crawler.CityMaoyanCrawler;
import com.family.grabserver.crawler.ShowPlanMaoyanCrawler;
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
    public ShowPlanMaoyanCrawler showCrawler;


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final GrabMaoyanRunner grabMaoyanRunner = applicationContext.getBean(GrabMaoyanRunner.class);
        grabMaoyanRunner.cityCrawler.crawl();
        grabMaoyanRunner.cinemaCrawler.crawl();
        grabMaoyanRunner.showCrawler.crawl();
        int a = 0;
    }
}