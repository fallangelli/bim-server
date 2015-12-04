package com.family.grabserver.model;

import com.family.grab.Page;
import com.family.grab.Site;
import com.family.grab.model.AfterExtractor;
import com.family.grab.model.ConsolePageModelPipeline;
import com.family.grab.model.OOSpider;
import com.family.grab.model.annotation.ExtractBy;
import com.family.grab.model.annotation.ExtractByUrl;
import com.family.grab.model.annotation.TargetUrl;
import org.slf4j.LoggerFactory;

@TargetUrl("http://m.maoyan.com/showtime/[\\w\\W]*")
public class ShowPlanMaoyanModel implements AfterExtractor {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @ExtractBy(value = "/html/body")
    private String context;

    @ExtractByUrl("cinemaid=(\\d*)")
    private String cinemaid = "";

    @ExtractByUrl("movieid=(\\d*)")
    private String movieid = "";


    public static void main(String[] args) {

        OOSpider.create(Site.me(), new ConsolePageModelPipeline(), ShowPlanMaoyanModel.class)
//                .addPipeline(new JsonFilePipeline("D:\\grab\\"))
//                .addPipeline(new ConsolePipeline())
                .addUrl("http://m.maoyan.com/showtime/wrap.json?cinemaid=1&movieid=78380").thread(1).run();


//        OOSpider.create(Site.me().setSleepTime(1000)
//                , new ConsolePageModelPipeline(), com.family.grabserver.model.DoubanComing.class)
//                .addUrl("http://movie.douban.com/coming")
//                .addPipeline(new JsonFilePipeline("D:\\grab\\"))
//                .addPipeline(new ConsolePipeline()).thread(5).run();
    }

    public String getContext() {
        context = context.replace("<body>", "");
        context = context.replace("</body>", "");
        context = context.replace("\n", "");
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCinemaid() {
        return cinemaid;
    }

    public void setCinemaid(String cinemaid) {
        this.cinemaid = cinemaid;
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

//    @Override
//    public String toString() {
//        String retVal = context;
//        return retVal;
//    }

    @Override
    public void afterProcess(Page page) {

    }

}