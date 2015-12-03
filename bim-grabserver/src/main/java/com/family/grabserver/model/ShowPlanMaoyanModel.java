package com.family.grabserver.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.family.grab.Page;
import com.family.grab.Site;
import com.family.grab.model.AfterExtractor;
import com.family.grab.model.ConsolePageModelPipeline;
import com.family.grab.model.OOSpider;
import com.family.grab.model.annotation.ExtractBy;
import com.family.grab.model.annotation.TargetUrl;
import org.slf4j.LoggerFactory;

@TargetUrl(value = "[\\w\\W]*")
public class ShowPlanMaoyanModel implements AfterExtractor {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @ExtractBy(value = "/html/body/text()")
    private String context;


    @ExtractBy(value = "/html/body/span[1]/text()")
    private String sell;

    private String source = "http://m.maoyan.com/showtime/wrap.json?cinemaid=**&movieid=**";

    public static void main(String[] args) {
        Site a = Site.me();
        a = a.addCookie("ci", "1")
                .addCookie("__mta", "251941430.1449133522188.1449133522188.1449133522188.1")
                .addCookie("__utma", "17099173.248164319.1449133508.1449133508.1449133508.1")
                .addCookie("__utmb", "17099173.4.9.1449133578034")
                .addCookie("__utmc", "17099173")
                .addCookie("__utmz", "17099173.1449133508.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)")
                .addCookie("isWebp", "1")
                .addCookie("JSESSIONID", "rebtpr4dhitcyihnfhujb8d7")
                .addCookie("iuuid", "00F0BDA0B294FDA539775C4233D05C72F76D27F34E495DD051095F3AEBFF051D");
        Object aa = a.getCookies();
        OOSpider.create(a
                        .setUserAgent("Mozilla/5.0 (Linux; U; Android 2.1; en-us; GT-I9000 Build/ECLAIR) AppleWebKit/525.10+ (KHTML, like Gecko) Version/3.0.4 Mobile Safari/523.12.2")
                        .setSleepTime(1000)
                , new ConsolePageModelPipeline(), ShowPlanMaoyanModel.class)
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
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

//    @Override
//    public String toString() {
//        String retVal = context;
//        return retVal;
//    }

    @Override
    public void afterProcess(Page page) {
        logger.info("cell:" + getSell());

        JSONObject ob = JSON.parseObject(context);
        JSONObject data = (JSONObject) ob.get("data");
        JSONObject dateShow = (JSONObject) data.get("DateShow");
        for (String key : dateShow.keySet()) {
            String currDate = key;
            JSONArray shows = (JSONArray) dateShow.get(key);
            for (Object showOb : shows) {
                JSONObject show = (JSONObject) showOb;

                logger.info("sellPrStr:" + show.getString("sellPrStr"));
                logger.info("prStr:" + show.getString("prStr"));

            }
        }

    }

}