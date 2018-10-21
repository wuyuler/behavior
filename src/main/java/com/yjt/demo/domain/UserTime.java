package com.yjt.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Entity
public class UserTime {

    @Id
    @GeneratedValue
    private int id;
    private String userId;
    private Date startDate;
    private Time startTime;
    private int lenTime;
    public UserTime(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getLenTime() {
        return lenTime;
    }

    public void setLenTime(int lenTime) {
        this.lenTime = lenTime;
    }
}
