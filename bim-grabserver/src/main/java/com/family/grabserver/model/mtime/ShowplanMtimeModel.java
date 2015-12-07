package com.family.grabserver.model.mtime;

import com.family.grab.Page;
import com.family.grab.Site;
import com.family.grab.model.AfterExtractor;
import com.family.grab.model.ConsolePageModelPipeline;
import com.family.grab.model.OOSpider;
import com.family.grab.model.annotation.ExtractBy;
import com.family.grab.model.annotation.ExtractByUrl;
import com.family.grab.model.annotation.TargetUrl;
import org.slf4j.LoggerFactory;

@TargetUrl("http://m.mtime.cn/Service/[\\w\\W]*")
public class ShowplanMtimeModel implements AfterExtractor {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @ExtractBy(value = "/html/body/text()")
    private String context;

    @ExtractByUrl("cinemaId=(\\d*)")
    private String cinemaId = "";

    @ExtractByUrl("movieId=(\\d*)")
    private String movieId = "";

    @ExtractByUrl("date=(\\d*-\\d*-\\d*)")
    private String showDate = "";

    public static void main(String[] args) {

        OOSpider.create(Site.me(), new ConsolePageModelPipeline(), ShowplanMtimeModel.class)
                .addUrl("http://m.mtime.cn/Service/callback.mi/showtime/ShowTimesByCinemaMovieDate.api?cinemaId=2342&movieId=216036&date=2015-12-07").thread(1).run();

    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }
//    @Override
//    public String toString() {
//        String retVal = context;
//        return retVal;
//    }

    @Override
    public void afterProcess(Page page) {

    }

}