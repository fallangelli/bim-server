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
public class MovieShowingMaoyanJsonParseTest {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    //    @Ignore
    @Test
    public void test() {
        String context = "{\"control\":{\"expires\":1800},\"status\":0,\"data\":{\"hasNext\":true,\"movies\":[{\"sn\":608,\"cnms\":58,\"late\":true,\"showDate\":\"\",\"src\":\"中国大陆\",\"nm\":\"怦然星动\",\"dur\":98,\"img\":\"http://p0.meituan.net/165.220/movie/5c63e738ad2b930f77f5b34972d06571326349.jpg\",\"sc\":9.1,\"ver\":\"2D\",\"rt\":\"本周四上映\",\"imax\":false,\"snum\":9136,\"scm\":\"明星不避嫌，触碰禁忌恋\",\"pn\":122,\"preSale\":0,\"vd\":\"\",\"dir\":\"陈国辉\",\"star\":\"杨幂,李易峰,陈数,王耀庆,张云龙,迪丽热巴,胡彦斌,金世佳,张政,刘泽宙,赵文杰,梁世民,高安艺,李欣泽,葛晓倩,刘亚鹏,王安琪,章静,冷海铭,张星雨,王晓青,李全友,杨峻宇,苏欣\",\"cat\":\"喜剧,爱情\",\"wish\":171654,\"3d\":false,\"id\":338503,\"time\":\"\"},{\"sn\":5,\"cnms\":3,\"late\":false,\"showDate\":\"\",\"src\":\"中国大陆\",\"nm\":\"从天儿降\",\"dur\":99,\"img\":\"http://p0.meituan.net/165.220/movie/55cb9d44cda167314f30e920cca5502a209601.jpg\",\"sc\":0.0,\"ver\":\"2D\",\"rt\":\"本周五上映\",\"imax\":false,\"snum\":4428,\"scm\":\"萌娃有神力，爱情有天意\",\"pn\":262,\"preSale\":1,\"vd\":\"\",\"dir\":\"魏民,魏楠\",\"star\":\"陈学冬,张艺兴,姜雯,李小璐,欧阳俊文,张瑶,于小伟,陈楚生,秦舒培,章子怡,黄晓婉,胡彦斌,释彦能,巴图,瑶淼,谷文泽,范湉湉\",\"cat\":\"喜剧,科幻,爱情\",\"wish\":85400,\"3d\":false,\"id\":246364,\"time\":\"\"},{\"sn\":7,\"cnms\":7,\"late\":false,\"showDate\":\"\",\"src\":\"中国大陆\",\"nm\":\"不可思异\",\"dur\":99,\"img\":\"http://p1.meituan.net/165.220/movie/d2f636cbbbfb60680de9d0f5e2887f261476005.jpg\",\"sc\":0.0,\"ver\":\"2D/3D/中国巨幕\",\"rt\":\"本周五上映\",\"imax\":false,\"snum\":4900,\"scm\":\"外星小魔球，特效有点牛\",\"pn\":238,\"preSale\":1,\"vd\":\"\",\"dir\":\"孙周\",\"star\":\"王宝强,小沈阳,董成鹏,杨抒文,尹正,成毅,辛芷蕾,潘米多,普超英,余皑磊,王伟波,曾帅,邵宇华,苏钰华,王浩然,盖立,孙之麟,游杰,金媛,伍晓君,孙周,赵多娜\",\"cat\":\"剧情,科幻,喜剧\",\"wish\":64076,\"3d\":true,\"id\":78380,\"time\":\"\"},{\"sn\":14,\"cnms\":14,\"late\":false,\"showDate\":\"\",\"src\":\"中国大陆\",\"nm\":\"杜拉拉追婚记\",\"dur\":101,\"img\":\"http://p1.meituan.net/165.220/movie/27b802ecc9a2ed1fd679814242b85132399461.jpg\",\"sc\":0.0,\"ver\":\"2D/中国巨幕\",\"rt\":\"本周五上映\",\"imax\":false,\"snum\":817,\"scm\":\"职场初得意，情场又遇敌\",\"pn\":90,\"preSale\":1,\"vd\":\"\",\"dir\":\"安竹间\",\"star\":\"周渝民,林依晨,陈柏霖,林珍娜,李佳航,邬君梅,邱木翰,陈妍希\",\"cat\":\"剧情,爱情\",\"wish\":73171,\"3d\":false,\"id\":342576,\"time\":\"\"},{\"sn\":476,\"cnms\":59,\"late\":false,\"showDate\":\"\",\"src\":\"美国\",\"nm\":\"火星救援\",\"dur\":144,\"img\":\"http://p0.meituan.net/165.220/movie/f7df200378e3725a4bc825397f5c9956130126.jpg\",\"sc\":8.9,\"ver\":\"3D/IMAX 3D/中国巨幕/全景声\",\"rt\":\"2015-11-25上映\",\"imax\":true,\"snum\":124763,\"scm\":\"孑然火星巅，归途何其险\",\"pn\":320,\"preSale\":0,\"vd\":\"\",\"dir\":\"雷德利·斯科特\",\"star\":\"马特·达蒙,杰西卡·查斯坦,克里斯汀·韦格,杰夫·丹尼尔斯,迈克尔·佩纳,肖恩·宾,凯特·玛拉,塞巴斯蒂安·斯坦,阿卡塞尔·亨涅,切瓦特·埃加福特,本尼迪特·王,麦肯齐·戴维斯,唐纳德·格洛沃,陈数,高雄,Jonathan Aris,布瑞恩·卡斯佩,彼得·舒莱尔,Fanni Krausz,尼古拉斯·惠特曼,Gayathri Kasupathipillai,彼得·林卡,Waleska Latorre,Zsofia Fekszi,迪克兰·汉尼根,查理·加德纳,James Fred Harkins Jr.,Takács Zalán,Scott Alexander Young,尼克·穆罕默德,Björn Freiberg,Nikolett Barabas,Gruffudd Glyn,Mark O'Neal,Karen Gagnon,Lili Bordán,娜奥米·斯科特,理查德·里夫金,Szonja Oroszlán,弗雷德里克·弗雷德,迪亚娜·布列娃,萨姆·斯普卢尔,Ben O'Brien,Balázs Medveczky,Xue Xuxing,Mike Kelly,Narantsogt Tsogtsaikhan,Yang Haiwen,Geoffrey Thomas\",\"cat\":\"动作,冒险,科幻\",\"wish\":130885,\"3d\":true,\"id\":246369,\"time\":\"\"}]}}";
        JSONObject ob = JSON.parseObject(context);
        JSONObject data = (JSONObject) ob.get("data");
        JSONArray movies = (JSONArray) data.get("movies");
        for (Object movieOb : movies) {
            JSONObject movie = (JSONObject) movieOb;
            movie.getInteger("id");
            movie.getString("nm");
            movie.getString("img");
            movie.getString("sc");
            movie.getBoolean("imax");
            movie.getBoolean("3d");
            movie.getString("dir");
            movie.getString("star");
            movie.getString("cat");
            movie.getString("scm");
            movie.getString("dur");
            movie.getString("ver");
        }
//        for (String key : cityMap.keySet()) {
//            String firstLetter = key;
//            JSONArray citys = (JSONArray) cityMap.get(key);
//            for (Object cityOb : citys) {
//                JSONObject city = (JSONObject) cityOb;
//                city.getString("id");
//                city.getString("name");
//                city.getString("pinyin");
//            }
//        }
    }
}
