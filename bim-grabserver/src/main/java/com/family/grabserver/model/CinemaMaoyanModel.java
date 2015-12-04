package com.family.grabserver.model;

import com.family.grab.Page;
import com.family.grab.Site;
import com.family.grab.model.AfterExtractor;
import com.family.grab.model.ConsolePageModelPipeline;
import com.family.grab.model.OOSpider;
import com.family.grab.model.annotation.ExtractBy;
import com.family.grab.model.annotation.ExtractByUrl;
import com.family.grab.model.annotation.TargetUrl;
import com.family.grab.pipeline.ConsolePipeline;
import com.family.grab.pipeline.JsonFilePipeline;

@TargetUrl(value = "http://m.maoyan.com/[\\w\\W]*")
public class CinemaMaoyanModel implements AfterExtractor {

    @ExtractBy(value = "/html/body/text()")
    private String context;


    @ExtractByUrl("cityName=(\\w*\\W*)")
    private String cityName = "";

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new ConsolePageModelPipeline(), CinemaMaoyanModel.class)
                .addPipeline(new JsonFilePipeline("D:\\grab\\"))
                .addPipeline(new ConsolePipeline())
                .addUrl("http://m.maoyan.com/showtime/wrap.json?cinemaid=153").thread(5).run();
//        OOSpider.create(Site.me().setSleepTime(1000)
//                , new ConsolePageModelPipeline(), com.family.grabserver.model.DoubanComing.class)
//                .addUrl("http://movie.douban.com/coming")
//                .addPipeline(new JsonFilePipeline("D:\\grab\\"))
//                .addPipeline(new ConsolePipeline()).thread(5).run();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        String retVal = context;
        return retVal;
    }

    @Override
    public void afterProcess(Page page) {

    }

}