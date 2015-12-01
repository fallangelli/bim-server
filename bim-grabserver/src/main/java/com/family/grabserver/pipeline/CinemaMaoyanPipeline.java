package com.family.grabserver.pipeline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.family.grab.Task;
import com.family.grab.pipeline.PageModelPipeline;
import com.family.grabserver.entity.CinemaMaoyan;
import com.family.grabserver.model.MaoyanCinemaModel;
import com.family.grabserver.service.CinemaMaoyanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午8:56
 */
@Component
public class CinemaMaoyanPipeline implements PageModelPipeline<MaoyanCinemaModel> {
    @Autowired
    private CinemaMaoyanService service;

    @Override
    public void process(MaoyanCinemaModel model, Task task) {
        String context = model.getContext();
        JSONObject ob = JSON.parseObject(context);
        JSONObject data = (JSONObject) ob.get("data");
        JSONObject cinemaDetailModel = (JSONObject) data.get("cinemaDetailModel");

        CinemaMaoyan record = new CinemaMaoyan();
        record.setId(cinemaDetailModel.getInteger("id"));

        record.setNm(cinemaDetailModel.getString("nm"));
        record.setCt(cinemaDetailModel.getString("ct"));
        record.setArea(cinemaDetailModel.getString("area"));
        record.setAddr(cinemaDetailModel.getString("addr"));
        record.setLat(cinemaDetailModel.getString("lat"));
        record.setLng(cinemaDetailModel.getString("lng"));
        record.setTel(cinemaDetailModel.getString("tel"));

        record.setUrl(model.getUrl());

        service.insertOrUpate(record);
    }
}