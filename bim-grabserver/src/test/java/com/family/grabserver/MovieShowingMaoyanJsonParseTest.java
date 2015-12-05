package com.family.grabserver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.slf4j.LoggerFactory;


/**
 * User: cairne
 * Date: 13-5-13
 * Time: 下午8:33
 */
public class MovieshowingMaoyanJsonParseTest {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    //    @Ignore
    @Test
    public void test() {
        String context = "{\"control\":{\"expires\":43200},\"status\":0,\"data\":{\"Dates\":[],\"CinemaListMap\":{},\"MovieDetailModel\":{\"dealsum\":0,\"photos\":[\"http://p0.meituan.net/w.h/movie/17/108718_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/639225_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/635088_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/192098_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/421961_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/427267_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/159887_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/583122_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/572883_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/601798_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/379761_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/501022_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/924657_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/554574_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/686522_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/149578_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/373451_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/699252_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/855954_N*N.jpg\",\"http://p0.meituan.net/w.h/movie/17/801713_N*N.jpg\"],\"showSnum\":true,\"isShowing\":true,\"wishst\":0,\"vnum\":1,\"mk\":0.0,\"pn\":51,\"mtc\":\"<p><b>玩命杰森的不老传奇 既然玩命，就死拼到底。继吕克•贝松导演为杰森量身打造《玩命速递》系列后，杰森•斯坦森的英雄形象也在年青一代中一举成名。玩命人贩的风生水起，杰森的《死亡飞车》又继续演绎他高超的飙车技术。杰森热潮沉浪追击，一波有一波玩命系列并未殆尽。</p><br/><p>    无法控制正义情绪的杰森，因暴打歹徒而被迫上报，被迫上报成为了警界的反面公众人物。同时也刺激了受警察迫害过的杀手“闪电”，为了寻仇便策划了一系列连环杀警事件的一出名，被受“关注”的杰森同他的同性恋上司波特·纳什，这对搞笑二人组对“闪电”展开了穷胜追击。受尽屈辱的警方，对铁锤杀人这简单的手法不但无能为力，杀手细致掩盖证据的手段让案件更是一筹莫展。愚弄警察，竟是在他们眼皮底下耍宝，都不知察觉，让警方更陷入在一片死亡气息中。这个城市的黑暗，连警察都性命不保，极度压迫的刺激感充斥整部影片。为了求生，就跟歹徒玩命一绝。</p><br/><p>    许多人因为爱上玩命而爱上杰森，不容错过的《玩命追踪》，让你见识下病猫也发威。</p>\",\"uc\":\"艾丹 •吉伦在片中扮演杀人魔，形如“年轻版的加里 •奥德曼”。——制片人：Steve Chasman\",\"dra\":\"<p>个性容易冲动火爆的布兰特（杰森·斯坦森 饰），有一次在街头遇上三个混混试图要偷走他的车，身为警官的他竟然动用私刑痛打了这三名嫌犯，因此他被强制接受心理咨询……某天，城市出现了一名专杀警官的连续杀人魔，他的凶器是一把锤子，无人知道他的踪迹，而他靠着连续犯案来追求社会的关注。布兰特奉命追查这名凶手，面对凶残狂妄凶手的放肆挑衅，布兰特真的火大了，既然法律都没办法制裁这名凶手，他决定要靠自己的双手，为这个社会伸张正义！</p>\",\"preSale\":0,\"late\":false,\"vd\":\"http://v.meituan.net/movie/__17550847__3809509.mp4\",\"dir\":\"艾略特·莱斯特 \",\"star\":\"杰森·斯坦森 帕迪·康斯戴恩 艾丹·吉伦 扎威·阿什顿 大卫·莫瑞瑟 奈德·丹内利 马克·里朗斯 卢克·伊万斯 尼基·汉森 Steven Harwood-Brown null 理查德·瑞德尔 Ron Donachie Elly Fairman Alex Lanipekun null null Nabil Elouhabi null 约瑟夫·戴浦西 Mickey Hughes 斯尔詹索里克 Gregory Finnegan null Taylor James Aldonio Danny Freitas Mens-Sana Tamakloe null Ralph Laurila Reece Beaumont null 嘉敏·肯纳 null 菲利克斯·斯科特 鲁珀特·霍利迪-埃文斯 克里斯蒂娜·科尔 Jessica Swain Des Barron 卢克·巴隆 John Burton Rebecca Eve Rishi Ghosh Julie Hoult Ian Hughes Shiden Mezghebe Joanna Miller Mike Parish 克里斯托弗·威尔森 \",\"cat\":\"动作,犯罪,惊悚\",\"wish\":192,\"3d\":false,\"showDate\":\"\",\"src\":\"英国\",\"nm\":\"玩命追踪\",\"img\":\"http://p0.meituan.net/165.220/movie/63a2e5ec37b7e00abeeae07f112f2866149154.jpg\",\"sc\":7.2,\"ver\":\"2D\",\"rt\":\"2012-03-16上映\",\"dur\":97,\"scm\":\"闪电杀人狂，专门害警方\",\"imax\":false,\"snum\":312,\"id\":117,\"time\":\"\"}}}\n";
        JSONObject ob = JSON.parseObject(context);
        JSONObject data = (JSONObject) ob.get("data");
        JSONObject movie = (JSONObject) data.get("MovieDetailModel");
        logger.info(movie.getString("mtc"));
    }
}
