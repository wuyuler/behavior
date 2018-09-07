package com.yjt.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NetUser {

    @Id
    private String id;
    private String gender;
    private String birthday;
    private String edu;
    private String job;
    private String income;
    private String province;
    private String city;
    private String isCity;


    public NetUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIsCity() {
        return isCity;
    }

    public void setIsCity(String isCity) {
        this.isCity = isCity;
    }
}
