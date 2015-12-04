package com.family.grabserver.crawler;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grabserver.entity.CinemaMovieMaoyan;
import com.family.grabserver.model.MovieShowingMaoyanModel;
import com.family.grabserver.model.ShowPlanMaoyanModel;
import com.family.grabserver.pipeline.MovieShowingMaoyanPipeline;
import com.family.grabserver.pipeline.ShowPlanMaoyanPipeline;
import com.family.grabserver.service.CinemaMovieMaoyanService;
import com.family.grabserver.service.MovieShowingMaoyanService;
import com.family.grabserver.util.SqlUtil;
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
    private MovieShowingMaoyanPipeline movieShowingMaoyanPipeline;
    @Autowired
    private MovieShowingMaoyanService movieService;
    @Autowired
    private CinemaMovieMaoyanService cinemaMovieService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        try {
            SqlUtil.deleteAll("show_plan_maoyan");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext*.xml");
        final ShowPlanMaoyanCrawler jsonCrawler = applicationContext.getBean(ShowPlanMaoyanCrawler.class);
        jsonCrawler.crawl();
    }

    public void crawl() {
        List<CinemaMovieMaoyan> cmList = cinemaMovieService.selectAll();


        StringArray urls = new StringArray();
        for (CinemaMovieMaoyan cm : cmList) {

            //电影不存在则添加
            if (movieService.selectByPrimaryKey(cm.getMovieId()) == null) {
                logger.info("添加电影基本信息 - " + cm.getMovieId());
                OOSpider.create(Site.me().setTimeOut(10000).setRetryTimes(5).setRetrySleepTime(3000),
                        movieShowingMaoyanPipeline, MovieShowingMaoyanModel.class)
                        .addUrl("http://m.maoyan.com/cinemas/list.json?movieid=" + cm.getMovieId())
                        .thread(1).run();
            }

            String movieUrl = "http://m.maoyan.com/showtime/wrap.json?cinemaid="
                    + cm.getCinemaId() + "&movieid=" + cm.getMovieId();
            urls.add(movieUrl);
        }
        logger.info("开始抓取猫眼场次信息 - ");
        OOSpider.create(Site.me().setRetryTimes(5).setRetrySleepTime(3000),
                pipeline, ShowPlanMaoyanModel.class)
                .addUrl(urls.getArray())
                .thread(200).run();
    }

}
