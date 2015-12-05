package com.family.grabserver.crawler.maoyan;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grabserver.entity.CinemaMaoyan;
import com.family.grabserver.model.maoyan.CinemamovieMaoyanModel;
import com.family.grabserver.pipeline.maoyan.CinemaMoiveMaoyanPipeline;
import com.family.grabserver.service.CinemaMaoyanService;
import com.family.grabserver.util.SqlUtil;
import com.sun.xml.internal.fastinfoset.util.StringArray;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CinemamovieMaoyanCrawler {
    @Autowired
    private CinemaMoiveMaoyanPipeline pipeline;

    @Autowired
    private CinemaMaoyanService cinemaService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        try {
            SqlUtil.deleteAll("cinema_movie_maoyan");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final CinemamovieMaoyanCrawler jsonCrawler = applicationContext.getBean(CinemamovieMaoyanCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {
        List<CinemaMaoyan> allCinema = cinemaService.selectAll();
        StringArray urls = new StringArray();
        for (CinemaMaoyan cinema : allCinema) {
            String url = "http://m.maoyan.com/showtime/wrap.json?cinemaid=" + cinema.getId();
            urls.add(url);
        }
        logger.info("开始抓取影院上映电影");
        OOSpider.create(Site.me().setRetryTimes(5).setRetrySleepTime(1000),
                pipeline, CinemamovieMaoyanModel.class).addUrl(urls.getArray())
                .thread(100).run();
    }
}
