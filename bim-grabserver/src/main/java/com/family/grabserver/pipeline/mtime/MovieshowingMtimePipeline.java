package com.family.grabserver.pipeline.mtime;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.family.grab.Task;
import com.family.grab.pipeline.PageModelPipeline;
import com.family.grabserver.entity.MovieshowingMtime;
import com.family.grabserver.model.mtime.MovieshowingMtimeModel;
import com.family.grabserver.service.MovieshowingMtimeService;
import com.family.grabserver.util.JsonStringUtil;
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
        record.setHasImax(movie.getBoolean("isIMAX"));
        record.setHas3d(movie.getBoolean("is3D"));

        JSONArray dirs = movie.getJSONArray("directors");
        record.setDir(JsonStringUtil.toSplitString(dirs));

        JSONArray actors = movie.getJSONArray("actors");
        record.setStar(JsonStringUtil.toSplitString(actors));

        JSONArray types = movie.getJSONArray("type");
        record.setCat(JsonStringUtil.toSplitString(types));

        record.setScm(movie.getString("content"));
        record.setDur(movie.getString("runTime"));
        service.insertOrUpate(record);
    }
}