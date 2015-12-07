package com.family.grabserver.crawler.maoyan;

import com.family.grab.Site;
import com.family.grab.model.OOSpider;
import com.family.grabserver.model.maoyan.CinemaMaoyanModel;
import com.family.grabserver.pipeline.maoyan.CinemaMaoyanPipeline;

/**
 * Created by Administrator on 2015/12/7.
 */
public class CinemaThread implements Runnable {
    CinemaMaoyanPipeline cinemaMaoyanPipeline;
    Integer cityId;
    String url;

    public CinemaThread(CinemaMaoyanPipeline cinemaMaoyanPipeline, Integer cityId, String url) {
        this.cinemaMaoyanPipeline = cinemaMaoyanPipeline;
        this.cityId = cityId;
        this.url = url;
    }

    @Override
    public void run() {
        OOSpider.create(Site.me().setTimeOut(30000).setSleepTime(500).setCycleRetryTimes(5).setRetrySleepTime(3000)
                        .addCookie("ci", cityId.toString()),
                cinemaMaoyanPipeline, CinemaMaoyanModel.class)
                .addUrl(url)
                .thread(1).run();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CinemaMaoyanPipeline getCinemaMaoyanPipeline() {
        return cinemaMaoyanPipeline;
    }

    public void setCinemaMaoyanPipeline(CinemaMaoyanPipeline cinemaMaoyanPipeline) {
        this.cinemaMaoyanPipeline = cinemaMaoyanPipeline;
    }

}
