package com.family.grabserver.model;

import com.family.grab.Page;
import com.family.grab.model.AfterExtractor;
import com.family.grab.model.annotation.ExtractBy;
import com.family.grab.model.annotation.ExtractByUrl;
import com.family.grab.model.annotation.TargetUrl;

@TargetUrl(value = "http://m.maoyan.com/[\\w\\W]*")
public class CinemaMovieMaoyanModel implements AfterExtractor {

    @ExtractBy(value = "/html/body/text()")
    private String context;

    @ExtractByUrl("cinemaid=(\\d*)")
    private String cinemaid = "";

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCinemaid() {
        return cinemaid;
    }

    public void setCinemaid(String cinemaid) {
        this.cinemaid = cinemaid;
    }

    @Override
    public String toString() {
        String retVal = context;
        return retVal;
    }

    @Override
    public void afterProcess(Page page) {

    }

}