package com.yjt.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Appcount {


    private int id;
    private String userid;
    private String appname;
    private Long count;
    private String job;
    private String province;
    private Short birthday;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "appname")
    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    @Basic
    @Column(name = "count")
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Basic
    @Column(name = "job")
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "birthday")
    public Short getBirthday() {
        return birthday;
    }

    public void setBirthday(Short birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appcount appcount = (Appcount) o;
        return id == appcount.id &&
                Objects.equals(userid, appcount.userid) &&
                Objects.equals(appname, appcount.appname) &&
                Objects.equals(count, appcount.count) &&
                Objects.equals(job, appcount.job) &&
                Objects.equals(province, appcount.province) &&
                Objects.equals(birthday, appcount.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, appname, count, job, province, birthday);
    }
}
