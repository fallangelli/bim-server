package com.family.grabserver.pipeline.mtime;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.family.grab.Task;
import com.family.grab.pipeline.PageModelPipeline;
import com.family.grabserver.entity.MovieshowingMtime;
import com.family.grabserver.model.mtime.MovieshowingMtimeModel;
import com.family.grabserver.service.MovieshowingMtimeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieshowingMtimePipeline implements PageModelPipeline<MovieshowingMtimeModel> {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieshowingMtimeService service;


    @Override
    public void process(MovieshowingMtimeModel model, Task task) {
        String context = model.getContext();

        JSONObject movie = JSON.parseObject(context);

        MovieshowingMtime record = new MovieshowingMtime();
        record.setId(Integer.parseInt(model.getMovieId()));
        record.setNm(movie.getString("titleCn"));
        record.setImg(movie.getString("image"));
        record.setSc(movie.getString("rating"));
        record.setImax(movie.getBoolean("isIMAX"));
        record.setIs3d(movie.getBoolean("is3D"));
        record.setDir(movie.getString("directors"));
        record.setStar(movie.getString("actors"));
        record.setCat(movie.getString("type"));
        record.setScm(movie.getString("content"));
        record.setDur(movie.getString("runTime"));
        service.insertOrUpate(record);
    }
}