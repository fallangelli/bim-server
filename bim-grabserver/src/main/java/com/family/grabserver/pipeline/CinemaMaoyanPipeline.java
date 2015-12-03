package com.family.grabserver.pipeline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.family.grab.Task;
import com.family.grab.pipeline.PageModelPipeline;
import com.family.grabserver.entity.CinemaMaoyan;
import com.family.grabserver.model.CinemaMaoyanModel;
import com.family.grabserver.service.CinemaMaoyanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CinemaMaoyanPipeline implements PageModelPipeline<CinemaMaoyanModel> {

    @Autowired
    private CinemaMaoyanService service;

    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public void process(CinemaMaoyanModel model, Task task) {
        String context = model.getContext();
        JSONObject ob = JSON.parseObject(context);
        JSONObject data = (JSONObject) ob.get("data");
        for (String key : data.keySet()) {
            String area = key;
            JSONArray cinemaArray = (JSONArray) data.get(key);
            for (Object cinemaOb : cinemaArray) {
                JSONObject cinema = (JSONObject) cinemaOb;
                CinemaMaoyan record = new CinemaMaoyan();
                record.setId(cinema.getInteger("id"));
                record.setCt(cityName);
                record.setNm(cinema.getString("nm"));
                record.setArea(cinema.getString("area"));
                record.setAddr(cinema.getString("addr"));

                record.setLat(cinema.getString("lat"));
                record.setLng(cinema.getString("lng"));

                record.setSell(cinema.getBoolean("sell"));
                record.setPreferential(cinema.getBoolean("preferential"));
                record.setImax(cinema.getBoolean("imax"));

//todo
//                record.setTel();

                service.insertOrUpate(record);
            }
        }

    }
}