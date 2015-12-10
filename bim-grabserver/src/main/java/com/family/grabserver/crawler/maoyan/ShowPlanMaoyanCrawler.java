package com.family.grabserver.crawler.maoyan;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grabserver.entity.CinemamovieMaoyan;
import com.family.grabserver.model.maoyan.MovieshowingMaoyanModel;
import com.family.grabserver.model.maoyan.ShowplanMaoyanModel;
import com.family.grabserver.pipeline.maoyan.MovieshowingMaoyanPipeline;
import com.family.grabserver.pipeline.maoyan.ShowplanMaoyanPipeline;
import com.family.grabserver.service.CinemamovieMaoyanService;
import com.family.grabserver.service.MovieshowingMaoyanService;
import com.family.grabserver.util.SqlUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShowplanMaoyanCrawler {
    @Autowired
    private ShowplanMaoyanPipeline pipeline;
    @Autowired
    private MovieshowingMaoyanPipeline movieShowingMaoyanPipeline;
    @Autowired
    private MovieshowingMaoyanService movieService;
    @Autowired
    private CinemamovieMaoyanService cinemaMovieService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final ShowplanMaoyanCrawler jsonCrawler = applicationContext.getBean(ShowplanMaoyanCrawler.class);
        jsonCrawler.crawl();
        System.exit(0);
    }

    public void crawl() {
        try {
            SqlUtil.deleteAll("showplan_maoyan");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }


        List<CinemamovieMaoyan> cmList = cinemaMovieService.selectAll();


        List<String> urls = new ArrayList<>();
        for (CinemamovieMaoyan cm : cmList) {

            //电影不存在则添加
            if (movieService.selectByPrimaryKey(cm.getMovieId()) == null) {
                logger.info("添加 猫眼 电影基本信息 - " + cm.getMovieId());
                OOSpider.create(Site.me().setTimeOut(30000).setSleepTime(500).setCycleRetryTimes(5).setRetrySleepTime(3000),
                        movieShowingMaoyanPipeline, MovieshowingMaoyanModel.class)
                        .addUrl("http://m.maoyan.com/cinemas/list.json?movieid=" + cm.getMovieId())
                        .thread(1).run();
            }

            String movieUrl = "http://m.maoyan.com/showtime/wrap.json?cinemaid="
                    + cm.getCinemaId() + "&movieid=" + cm.getMovieId();
            urls.add(movieUrl);
        }
        logger.info("开始抓取 猫眼 场次信息");
        OOSpider.create(Site.me().setTimeOut(30000).setSleepTime(500).setCycleRetryTimes(5).setRetrySleepTime(3000),
                pipeline, ShowplanMaoyanModel.class)
                .addUrl((String[]) urls.toArray(new String[]{}))
                .thread(200).run();
    }

}
