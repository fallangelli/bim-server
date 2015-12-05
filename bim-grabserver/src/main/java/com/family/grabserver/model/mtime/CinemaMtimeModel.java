package com.family.grabserver.model.mtime;

import com.family.grab.Page;
import com.family.grab.Site;
import com.family.grab.model.AfterExtractor;
import com.family.grab.model.ConsolePageModelPipeline;
import com.family.grab.model.OOSpider;
import com.family.grab.model.annotation.ExtractBy;
import com.family.grab.model.annotation.ExtractByUrl;
import com.family.grab.model.annotation.TargetUrl;

@TargetUrl(value = "http://m.mtime.cn/[\\w\\W]*")
public class CinemaMtimeModel implements AfterExtractor {

    @ExtractBy(value = "/html/body/text()")
    private String context;


    @ExtractByUrl("locationId=(\\d*)[&]?")
    private String cityId = "";

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new ConsolePageModelPipeline(), CinemaMtimeModel.class)
                .addUrl("http://m.mtime.cn/Service/callback.mi/OnlineLocationCinema/OnlineCinemasByCity.api?locationId=290")
                .thread(1).run();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
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