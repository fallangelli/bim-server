package com.family.grabserver.pipeline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.family.grab.Task;
import com.family.grab.pipeline.PageModelPipeline;
import com.family.grabserver.entity.ShowPlanMaoyan;
import com.family.grabserver.model.ShowPlanMaoyanModel;
import com.family.grabserver.service.ShowPlanMaoyanService;
import com.family.grabserver.util.MaoyanPriceDecoder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ShowPlanMaoyanPipeline implements PageModelPipeline<ShowPlanMaoyanModel> {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ShowPlanMaoyanService service;


    @Override
    public void process(ShowPlanMaoyanModel model, Task task) {
        String context = model.getContext();

        Pattern p0 = Pattern.compile("(<span class=[\\w\\W]*?</i></span>)");
        Matcher m0 = p0.matcher(context);
        while (m0.find()) {
            String item = m0.group();
            String itemNew = item.replace("\\\"", "");
            itemNew = itemNew.replace("\"", "'");
            context = context.replace(item, itemNew);
        }

        String decodeCssContent = "";
        Pattern p = Pattern.compile("\"cssLink\":\"([\\w\\W]*css)\"}");
        Matcher m = p.matcher(context);
        if (m.find()) {
            String url = m.group(1);
            try {
                HttpGet request = new HttpGet(url);
                HttpResponse response = null;
                response = HttpClients.createDefault().execute(request);
                if (response.getStatusLine().getStatusCode() == 200) {
                    decodeCssContent = EntityUtils.toString(response.getEntity());
                } else {
                    logger.error("无法获取解码css内容" + context);
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            logger.error("无法获取解码css地址" + context);
            return;
        }

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
                    record.setCinemaId(Integer.parseInt(model.getCinemaid()));
                    record.setMovieId(Integer.parseInt(model.getMovieid()));
                    record.setDt(show.getDate("dt"));
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    Date tm = sdf.parse(show.getString("tm"));
                    record.setTm(tm);
                    Date end = sdf.parse(show.getString("end"));
                    record.setEnd(end);

                    record.setLang(show.getString("lang"));
                    record.setTh(show.getString("th"));
                    record.setTp(show.getString("tp"));

                    Float sellPr = MaoyanPriceDecoder.decode(show.getString("sellPrStr"), decodeCssContent);
                    record.setSellpr(sellPr);
                    Float pr = MaoyanPriceDecoder.decode(show.getString("prStr"), decodeCssContent);
                    record.setPr(pr);
                } catch (ParseException e) {
                    e.printStackTrace();
                    continue;
                }
                service.insertOrUpate(record);
            }
        }
    }
}