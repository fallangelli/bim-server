package com.family.grabserver.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.family.grab.Page;
import com.family.grab.Request;
import com.family.grab.Site;
import com.family.grab.downloader.HttpClientDownloader;
import com.family.grab.model.OOSpider;
import com.family.grab.pipeline.ConsolePipeline;
import com.family.grabserver.entity.CinemaMaoyan;
import com.family.grabserver.model.ShowPlanMaoyanModel;
import com.family.grabserver.pipeline.ShowPlanMaoyanPipeline;
import com.family.grabserver.service.CinemaMaoyanService;
import com.sun.xml.internal.fastinfoset.util.StringArray;
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
    private CinemaMaoyanService cinemaService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final ShowPlanMaoyanCrawler jsonCrawler = applicationContext.getBean(ShowPlanMaoyanCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {
        List<CinemaMaoyan> allCinema = cinemaService.selectAll();
        for (CinemaMaoyan cinema : allCinema) {
            logger.info("start getting movies from maoyan in " + cinema.getNm());
            String url = "http://m.maoyan.com/showtime/wrap.json?cinemaid=" + cinema.getId();

            Site site = Site.me();
            HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
            Page download = httpClientDownloader.download(new Request(url), site.toTask());

            String context = download.getRawText();
            JSONObject ob = JSON.parseObject(context);
            JSONObject data = (JSONObject) ob.get("data");
            JSONArray movies = (JSONArray) data.get("movies");

            StringArray urls = new StringArray();
            for (Object moiveOb : movies) {
                JSONObject moive = (JSONObject) moiveOb;
                String movieUrl = "http://m.maoyan.com/showtime/wrap.json?cinemaid="
                        + cinema.getId() + "&movieid=" + moive.getInteger("id");
                urls.add(movieUrl);
            }

            OOSpider.create(Site.me(),
                    pipeline, ShowPlanMaoyanModel.class)
                    .addUrl(urls.getArray())
                    .addPipeline(new ConsolePipeline()).thread(1).run();
        }
    }
}
