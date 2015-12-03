package com.family.grabserver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.slf4j.LoggerFactory;


/**
 * User: cairne
 * Date: 13-5-13
 * Time: 下午8:33
 */
public class ShowPlanMaoyanJsonParseTest {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    //    @Ignore
    @Test
    public void test() {
        String context = "{\"control\":{\"expires\":120},\"status\":0,\"data\":{\"Dates\":[{\"text\":\"明天 12月04日\",\"slug\":\"2015-12-04\"}],\"currentMovie\":{\"nm\":\"极盗者\",\"img\":\"http://p1.meituan.net/165.220/movie/b8a6b0b27bdc633378ad047746bc4f49387554.jpg\",\"sc\":0.0,\"preferential\":0,\"ver\":\"2D/3D/中国巨幕\",\"isShowing\":false,\"id\":249141},\"cinemaDetailModel\":{\"addr\":\"朝阳区京顺路111号比如世界购物中心1层（近太阳宫北街）\",\"price\":0.0,\"nm\":\"17.5影城(比如世界店)\",\"preferential\":0,\"sellmin\":0,\"sell\":true,\"ct\":\"北京\",\"area\":\"朝阳区\",\"bus\":\"乘131/401/403/404/627/967路公交车在四元桥西站下车即是。\",\"park\":\"停车场车位充足，免费停车。\",\"imax\":0,\"snum\":54,\"s\":7.759259,\"s1\":7.0740743,\"s2\":6.9444447,\"s3\":7.111111,\"featureTags\":[{\"desc\":\"限网上选座后取票\",\"type\":1,\"tag\":\"取票机\"},{\"desc\":\"1.3m（含1.3m）以下儿童观看动画票和3D影片需要买票，观看2D非动画片可以免票需一名成人陪同无座。\",\"type\":7,\"tag\":\"儿童优惠\"},{\"desc\":\"停车场车位充足，免费停车。\",\"type\":5,\"tag\":\"可停车\"},{\"desc\":\"免费使用\",\"type\":4,\"tag\":\"3D眼镜\"},{\"desc\":\"影院大厅有休息区\",\"type\":10,\"tag\":\"休息区\"},{\"desc\":\"前台可刷卡\",\"type\":8,\"tag\":\"可刷卡\"}],\"callboard\":\"\",\"brd\":\"17.5影城\",\"dis\":\"望京\",\"lng\":116.462135,\"lat\":39.967995,\"tel\":[\"010-64304176\"],\"suw\":\"乘10号线在三元桥站C1口出，步行至四元桥即是。\",\"dri\":\"暂无\",\"note\":\"\",\"dealtp\":0,\"deals\":[{\"price\":10.5,\"title\":\"10.5元，1中爆米花、1中杯可乐1次，免预约\",\"id\":0,\"type\":1}],\"id\":48},\"movies\":[{\"nm\":\"火星救援\",\"img\":\"http://p0.meituan.net/165.220/movie/f7df200378e3725a4bc825397f5c9956130126.jpg\",\"sc\":8.9,\"preferential\":0,\"ver\":\"3D/IMAX 3D/中国巨幕/全景声\",\"isShowing\":true,\"id\":246369},{\"nm\":\"极盗者\",\"img\":\"http://p1.meituan.net/165.220/movie/b8a6b0b27bdc633378ad047746bc4f49387554.jpg\",\"sc\":0.0,\"preferential\":0,\"ver\":\"2D/3D/中国巨幕\",\"isShowing\":false,\"id\":249141},{\"nm\":\"不可思异\",\"img\":\"http://p1.meituan.net/165.220/movie/d2f636cbbbfb60680de9d0f5e2887f261476005.jpg\",\"sc\":0.0,\"preferential\":0,\"ver\":\"2D/3D/中国巨幕\",\"isShowing\":false,\"id\":78380},{\"nm\":\"怦然星动\",\"img\":\"http://p0.meituan.net/165.220/movie/5c63e738ad2b930f77f5b34972d06571326349.jpg\",\"sc\":9.1,\"preferential\":0,\"ver\":\"2D\",\"isShowing\":true,\"id\":338503},{\"nm\":\"海绵宝宝\",\"img\":\"http://p0.meituan.net/165.220/movie/b5a456ee150099b7f331004e1ea7df54390125.jpg\",\"sc\":8.5,\"preferential\":0,\"ver\":\"3D/中国巨幕\",\"isShowing\":true,\"id\":246024},{\"nm\":\"007：幽灵党\",\"img\":\"http://p0.meituan.net/165.220/movie/f4aad31c17436f73ef2a369c2e2188b1110089.jpg\",\"sc\":7.9,\"preferential\":0,\"ver\":\"2D/IMAX 2D/中国巨幕\",\"isShowing\":true,\"id\":78617},{\"nm\":\"我的少女时代\",\"img\":\"http://p1.meituan.net/165.220/movie/19e87124de0929c5df86cb760776afc5655939.jpg\",\"sc\":9.2,\"preferential\":0,\"ver\":\"2D\",\"isShowing\":true,\"id\":341569},{\"nm\":\"玩命速递：重启之战\",\"img\":\"http://p1.meituan.net/165.220/movie/38810e3cc2613ec5dc939f3bd9b46fa5359031.jpg\",\"sc\":8.3,\"preferential\":0,\"ver\":\"2D/3D/中国巨幕\",\"isShowing\":true,\"id\":247852},{\"nm\":\"从天儿降\",\"img\":\"http://p0.meituan.net/165.220/movie/55cb9d44cda167314f30e920cca5502a209601.jpg\",\"sc\":0.0,\"preferential\":0,\"ver\":\"2D\",\"isShowing\":false,\"id\":246364},{\"nm\":\"消失的凶手\",\"img\":\"http://p1.meituan.net/165.220/movie/2f369b627e44b0c9338ad562470665ca206314.jpg\",\"sc\":6.9,\"preferential\":0,\"ver\":\"2D/3D\",\"isShowing\":true,\"id\":246081},{\"nm\":\"灵臆事件\",\"img\":\"http://p0.meituan.net/165.220/movie/973441b7c81486bc907fff28aa2950db907214.jpg\",\"sc\":5.6,\"preferential\":0,\"ver\":\"2D\",\"isShowing\":true,\"id\":245982},{\"nm\":\"杜拉拉追婚记\",\"img\":\"http://p1.meituan.net/165.220/movie/27b802ecc9a2ed1fd679814242b85132399461.jpg\",\"sc\":0.0,\"preferential\":0,\"ver\":\"2D/中国巨幕\",\"isShowing\":false,\"id\":342576},{\"nm\":\"西藏天空\",\"img\":\"http://p0.meituan.net/165.220/movie/__39941761__1339587.jpg\",\"sc\":8.0,\"preferential\":0,\"ver\":\"2D\",\"isShowing\":true,\"id\":78927},{\"nm\":\"一个勺子\",\"img\":\"http://p0.meituan.net/165.220/movie/7406438bf10d58f46fabe343fcb395c5338537.jpg\",\"sc\":7.7,\"preferential\":0,\"ver\":\"2D\",\"isShowing\":true,\"id\":246198}],\"DateShow\":{\"2015-12-04\":[{\"end\":\"12:34\",\"showDate\":\"2015-12-04\",\"dt\":\"2015-12-04\",\"embed\":0,\"showId\":68183,\"preferential\":0,\"tm\":\"10:40\",\"sell\":true,\"lang\":\"英语\",\"grayDesc\":\"\",\"seatStatus\":1,\"tp\":\"3D\",\"isMorrow\":false,\"th\":\"2号厅\",\"sellPrStr\":\"930836\",\"prStr\":\"467925\"},{\"end\":\"13:54\",\"showDate\":\"2015-12-04\",\"dt\":\"2015-12-04\",\"embed\":0,\"showId\":68184,\"preferential\":0,\"tm\":\"12:00\",\"sell\":true,\"lang\":\"国语\",\"grayDesc\":\"\",\"seatStatus\":1,\"tp\":\"2D\",\"isMorrow\":false,\"th\":\"4号厅\",\"sellPrStr\":\"236456\",\"prStr\":\"060035\"},{\"end\":\"14:39\",\"showDate\":\"2015-12-04\",\"dt\":\"2015-12-04\",\"embed\":0,\"showId\":68185,\"preferential\":0,\"tm\":\"12:45\",\"sell\":true,\"lang\":\"英语\",\"grayDesc\":\"\",\"seatStatus\":1,\"tp\":\"3D\",\"isMorrow\":false,\"th\":\"2号厅\",\"sellPrStr\":\"432996\",\"prStr\":\"467455\"},{\"end\":\"15:59\",\"showDate\":\"2015-12-04\",\"dt\":\"2015-12-04\",\"embed\":0,\"showId\":68186,\"preferential\":0,\"tm\":\"14:05\",\"sell\":true,\"lang\":\"国语\",\"grayDesc\":\"\",\"seatStatus\":1,\"tp\":\"2D\",\"isMorrow\":false,\"th\":\"4号厅\",\"sellPrStr\":\"231966\",\"prStr\":\"761015\"},{\"end\":\"18:09\",\"showDate\":\"2015-12-04\",\"dt\":\"2015-12-04\",\"embed\":0,\"showId\":68187,\"preferential\":0,\"tm\":\"16:15\",\"sell\":true,\"lang\":\"国语\",\"grayDesc\":\"\",\"seatStatus\":1,\"tp\":\"2D\",\"isMorrow\":false,\"th\":\"4号厅\",\"sellPrStr\":\"432546\",\"prStr\":\"066475\"},{\"end\":\"19:19\",\"showDate\":\"2015-12-04\",\"dt\":\"2015-12-04\",\"embed\":0,\"showId\":68188,\"preferential\":0,\"tm\":\"17:25\",\"sell\":true,\"lang\":\"英语\",\"grayDesc\":\"\",\"seatStatus\":1,\"tp\":\"3D\",\"isMorrow\":false,\"th\":\"2号厅\",\"sellPrStr\":\"036606\",\"prStr\":\"266175\"},{\"end\":\"20:34\",\"showDate\":\"2015-12-04\",\"dt\":\"2015-12-04\",\"embed\":0,\"showId\":68189,\"preferential\":0,\"tm\":\"18:40\",\"sell\":true,\"lang\":\"英语\",\"grayDesc\":\"\",\"seatStatus\":1,\"tp\":\"3D\",\"isMorrow\":false,\"th\":\"3号厅\",\"sellPrStr\":\"433266\",\"prStr\":\"160455\"},{\"end\":\"22:04\",\"showDate\":\"2015-12-04\",\"dt\":\"2015-12-04\",\"embed\":0,\"showId\":68190,\"preferential\":0,\"tm\":\"20:10\",\"sell\":true,\"lang\":\"国语\",\"grayDesc\":\"\",\"seatStatus\":1,\"tp\":\"2D\",\"isMorrow\":false,\"th\":\"4号厅\",\"sellPrStr\":\"735436\",\"prStr\":\"468305\"}]},\"cssLink\":\"http://p0.meituan.net/movie/9d6a73ec563c77534cfcfa46fd30451e3392.css\"}}";
        JSONObject ob = JSON.parseObject(context);
        JSONObject data = (JSONObject) ob.get("data");
        JSONObject dateShow = (JSONObject) data.get("DateShow");
        for (String key : dateShow.keySet()) {
            String currDate = key;
            JSONArray shows = (JSONArray) dateShow.get(key);
            for (Object showOb : shows) {
                JSONObject show = (JSONObject) showOb;
                show.getInteger("showId");
                show.getDate("dt");
                show.getString("tm");
                show.getString("end");
                show.getString("lang");
                show.getString("th");
                show.getString("tp");
                show.getString("sellPrStr");
                show.getString("prStr");
            }
        }
    }
}
