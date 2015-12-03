package com.family.grabserver;

import com.family.grab.Site;
import com.family.grab.model.ConsolePageModelPipeline;
import com.family.grab.model.OOSpider;
import com.family.grab.model.annotation.ExtractBy;
import com.family.grab.model.annotation.TargetUrl;

@TargetUrl("http://m.maoyan.com/#type=cinemas")
//@HelpUrl("https://github.com/\\w+")
public class Maoyan {

    @ExtractBy(value = "//*[@id=\"frame\"]", notNull = true)
    private String body;
//
//    @ExtractByUrl("https://github\\.com/(\\w+)/.*")
//    private String author;
//
//    @ExtractBy("//div[@id='readme']/tidyText()")
//    private String readme;

    public static void main(String[] args) {
        OOSpider.create(Site.me().addCookie("ci", "50").setSleepTime(1000)
                , new ConsolePageModelPipeline(), Maoyan.class)
                .addUrl("http://m.maoyan.com/#type=cinemas").thread(5).run();
    }
}