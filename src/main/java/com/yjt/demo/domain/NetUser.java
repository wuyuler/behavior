package com.yjt.demo.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class NetUser {

    @Id
    private String id;
    private String gender;
    private int birthday;
    private String edu;
    private String job;
    private String income;
    private String province;
    private String city;
    private String isCity;

//    @ElementCollection
////    // 生成的表的主键Map.key+EmployeeMap_id
////    @CollectionTable(name = "net_data_url")
////    @MapKeyColumn(name = "data_date")
////    @Column(name = "data_url",columnDefinition = "TEXT")
////    private Map<String, String> others = new HashMap<String, String>();
////
////    @ElementCollection
////    // 生成的表的主键Map.key+EmployeeMap_id
////    @CollectionTable(name = "net_data_TP")
////    @MapKeyColumn(name = "data_L_start")
////    @Column(name = "data_TP",columnDefinition = "TEXT")
////    private Map<String, String> others2 = new HashMap<String, String>();

//    @OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.LAZY,mappedBy = "user")//这样会导致一个超级大的集合,内存直接报了
//    public Set<Time_start> list_time_start=new HashSet<>();

    @Override
    public String toString() {
        return "NetUser{" +
                "id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + (2012-birthday) +
                ", edu='" + edu + '\'' +
                ", job='" + job + '\'' +
                ", income='" + income + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", isCity='" + isCity + '\'' +
                '}';
    }

    public NetUser() {
    }

//    public Set<Time_start> getList_time_start() {
//        return list_time_start;
//    }
//
//    public void setList_time_start(Set<Time_start> list_time_start) {
//        this.list_time_start = list_time_start;
//    }

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

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
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
