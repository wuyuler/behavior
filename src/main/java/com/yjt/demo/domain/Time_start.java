package com.yjt.demo.domain;

import javax.persistence.*;



@Entity
public class Time_start {

    @Id
    @GeneratedValue
    private int id;

    @Column(columnDefinition = "TEXT")
    private String time_start;

    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private NetUser user;

//    @OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.LAZY,mappedBy = "time_start")//数据量太庞大了
//    private Set<Time_add> list_time_add=new HashSet<>();


    public Time_start() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public NetUser getUser() {
        return user;
    }

    public void setUser(NetUser user) {
        this.user = user;
    }
}
