package com.family.grabserver.pipeline.mtime;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.family.grab.Task;
import com.family.grab.pipeline.PageModelPipeline;
import com.family.grabserver.entity.ShowplanMtime;
import com.family.grabserver.model.mtime.ShowplanMtimeModel;
import com.family.grabserver.service.ShowplanMtimeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class ShowplanMtimePipeline implements PageModelPipeline<ShowplanMtimeModel> {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ShowplanMtimeService service;

    @Override
    public void process(ShowplanMtimeModel model, Task task) {
        String context = model.getContext();
        JSONObject ob = JSON.parseObject(context);
        JSONArray shows = (JSONArray) ob.get("s");
        for (Object showOb : shows) {

            JSONObject show = (JSONObject) showOb;

            if (show.getFloat("startTime") < 0) {
                continue;
            }

            ShowplanMtime record = new ShowplanMtime();

            record.setId(show.getInteger("sid"));
            record.setCinemaId(Integer.parseInt(model.getCinemaId()));
            record.setMovieId(Integer.parseInt(model.getMovieId()));

            DateFormat dtfmt = new SimpleDateFormat("yyyy-MM-dd");
            try {
                record.setDt(dtfmt.parse(model.getShowDate()));
            } catch (ParseException e) {
                logger.error("无法解析上映时间" + context);
                e.printStackTrace();
                return;
            }

            long showDay = show.getLong("showDay");
            Calendar cal = new GregorianCalendar();
            cal.clear();
            int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
            cal.setTimeInMillis(showDay * 1000 - zoneOffset);
            record.setTm(cal.getTime());
            cal.add(Calendar.MINUTE, show.getInteger("length"));
            record.setEnd(cal.getTime());

            record.setLang(show.getString("language"));

            record.setTh(show.getString("hall"));

            record.setTp(show.getString("versionDesc"));
            record.setSellpr(show.getFloat("salePrice") / 100);
            record.setPr(show.getFloat("cinemaPrice") / 100);

            service.insertOrUpate(record);

        }
    }
}