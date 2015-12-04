package com.family.grabserver.pipeline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.family.grab.Task;
import com.family.grab.pipeline.PageModelPipeline;
import com.family.grabserver.entity.CinemaMovieMaoyan;
import com.family.grabserver.model.CinemaMovieMaoyanModel;
import com.family.grabserver.service.CinemaMovieMaoyanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CinemaMoiveMaoyanPipeline implements PageModelPipeline<CinemaMovieMaoyanModel> {

    @Autowired
    private CinemaMovieMaoyanService service;

    @Override
    public void process(CinemaMovieMaoyanModel model, Task task) {
        String context = model.getContext();
        JSONObject ob = JSON.parseObject(context);
        JSONObject data = (JSONObject) ob.get("data");
        JSONArray movies = (JSONArray) data.get("movies");

        for (Object moiveOb : movies) {

            JSONObject moive = (JSONObject) moiveOb;
            CinemaMovieMaoyan record = new CinemaMovieMaoyan();

            record.setMovieId(moive.getInteger("id"));
            record.setCinemaId(Integer.parseInt(model.getCinemaid()));

            service.insertOrUpate(record);
        }
    }
}