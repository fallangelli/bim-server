package com.family.grabserver.pipeline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.family.grab.Task;
import com.family.grab.pipeline.PageModelPipeline;
import com.family.grabserver.entity.ShowPlanMaoyan;
import com.family.grabserver.model.ShowPlanMaoyanModel;
import com.family.grabserver.service.ShowPlanMaoyanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ShowPlanMaoyanPipeline implements PageModelPipeline<ShowPlanMaoyanModel> {

    @Autowired
    private ShowPlanMaoyanService service;

    private Integer cinemaId;

    private Integer movieId;


    @Override
    public void process(ShowPlanMaoyanModel model, Task task) {
        String context = model.getContext();
        JSONObject ob = JSON.parseObject(context);
        JSONObject data = (JSONObject) ob.get("data");
        JSONObject dateShow = (JSONObject) data.get("DateShow");
        for (String key : dateShow.keySet()) {
            String currDate = key;
            JSONArray shows = (JSONArray) dateShow.get(key);
            for (Object showOb : shows) {

                JSONObject show = (JSONObject) showOb;
                ShowPlanMaoyan record = new ShowPlanMaoyan();
                try {
                    record.setId(show.getInteger("showId"));
                    record.setCinemaId(cinemaId);
                    record.setMovieId(movieId);
                    record.setDt(show.getDate("dt"));
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    Date tm = sdf.parse(show.getString("tm"));
                    record.setTm(tm);
                    Date end = sdf.parse(show.getString("end"));
                    record.setEnd(end);

                    record.setLang(show.getString("lang"));
                    record.setTh(show.getString("th"));
                    record.setTp(show.getString("tp"));
                    record.setSellprstr(show.getString("sellPrStr"));
                    record.setPrstr(show.getString("prStr"));
                } catch (ParseException e) {
                    e.printStackTrace();
                    continue;
                }
                service.insertOrUpate(record);
            }
        }
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}