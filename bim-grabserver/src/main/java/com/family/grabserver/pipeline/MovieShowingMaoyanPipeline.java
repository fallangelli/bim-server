package com.family.grabserver.pipeline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.family.grab.Task;
import com.family.grab.pipeline.PageModelPipeline;
import com.family.grabserver.entity.MovieShowingMaoyan;
import com.family.grabserver.model.MovieShowingMaoyanModel;
import com.family.grabserver.service.MovieShowingMaoyanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieShowingMaoyanPipeline implements PageModelPipeline<MovieShowingMaoyanModel> {

    @Autowired
    private MovieShowingMaoyanService service;


    @Override
    public void process(MovieShowingMaoyanModel model, Task task) {
        String context = model.getContext();
        JSONObject ob = JSON.parseObject(context);
        JSONObject data = (JSONObject) ob.get("data");
        JSONArray movies = (JSONArray) data.get("movies");
        for (Object movieOb : movies) {
            JSONObject movie = (JSONObject) movieOb;
            MovieShowingMaoyan record = new MovieShowingMaoyan();
            record.setId(movie.getInteger("id"));
            record.setNm(movie.getString("nm"));
            record.setImg(movie.getString("img"));
            record.setSc(movie.getString("sc"));
            record.setSrc(movie.getString("src"));
            record.setImax(movie.getBoolean("imax"));
            record.setIs3d(movie.getBoolean("3d"));
            record.setDir(movie.getString("dir"));
            record.setStar(movie.getString("star"));
            record.setCat(movie.getString("cat"));
            record.setScm(movie.getString("scm"));
            record.setDur(movie.getString("dur"));
            record.setVer(movie.getString("ver"));
            service.insertOrUpate(record);
        }
    }
}