package com.yjt.demo.domain;

import javax.persistence.*;

@Entity
public class Time_add {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String time_add;
    @Column(columnDefinition = "TEXT")
    private String url;
    @Column(columnDefinition = "TEXT")
    private String process_name;
//    @Column(columnDefinition = "TEXT")
//    private String app_name;


    @ManyToOne(cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "time_start")
    private Time_start time_start;
    public Time_add() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTime_add() {
        return time_add;
    }

    public void setTime_add(String time_add) {
        this.time_add = time_add;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProcess_name() {
        return process_name;
    }

    public void setProcess_name(String process_name) {
        this.process_name = process_name;
    }



    public Time_start getTime_start() {
        return time_start;
    }

    public void setTime_start(Time_start time_start) {
        this.time_start = time_start;
    }
}
