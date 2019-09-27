package com.yjt.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Kmeans {
    @Id
    String userid;
    String userinfo;
    String netinfo;
    String timeinfo;

    public Kmeans(){
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    public String getNetinfo() {
        return netinfo;
    }

    public void setNetinfo(String netinfo) {
        this.netinfo = netinfo;
    }

    public String getTimeinfo() {
        return timeinfo;
    }

    public void setTimeinfo(String timeinfo) {
        this.timeinfo = timeinfo;
    }
}
