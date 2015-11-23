package com.family.grabserver;

import com.family.grabserver.model.DoubanComing;
import com.family.grabserver.pipeline.DoubanComingPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午4:19
 */
@Component
public class JobCrawler {


    //    @Qualifier("JobInfoDaoPipeline")
//    @Autowired
//    private PageModelPipeline jobInfoDaoPipeline;
//
//
    @Qualifier("DoubanComingPipeline")
    @Autowired
    private DoubanComingPipeline dcPipeline;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final JobCrawler jobCrawler = applicationContext.getBean(JobCrawler.class);
        jobCrawler.crawl();
    }

    public void crawl() {
        OOSpider.create(Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"),
                dcPipeline, DoubanComing.class).addUrl("http://movie.douban.com/coming")
                .addPipeline(new ConsolePipeline()).thread(5).run();
    }
}