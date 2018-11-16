package com.yjt.demo.domain;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Userbean {
    @Id
    String userid;

    @Column(nullable = true)
    int age;
    @Column(nullable = true)
    int job;
    @Column(nullable = true)
    int income;
    @Column(nullable = true)
    int edu;
    @Column(nullable = true)
    int nettime;


    public Userbean(String userid, int age, int job, int income, int edu, int nettime) {
        this.userid = userid;
        this.age = age;
        this.job = job;
        this.income = income;
        this.edu = edu;
        this.nettime = nettime;
    }

    @Override
    public String toString() {
        return "age=" + age +
                ", job=" + job +
                ", income=" + income +
                ", edu=" + edu +
                ", nettime=" + nettime;
    }

    public Userbean(int age, int job, int income, int edu, int nettime) {
        this.age = age;
        this.job = job;
        this.income = income;
        this.edu = edu;
        this.nettime = nettime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userbean userbean = (Userbean) o;
        return age == userbean.age &&
                job == userbean.job &&
                income == userbean.income &&
                edu == userbean.edu &&
                nettime == userbean.nettime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, job, income, edu, nettime);
    }

    public Userbean() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getEdu() {
        return edu;
    }

    public void setEdu(int edu) {
        this.edu = edu;
    }

    public int getNettime() {
        return nettime;
    }

    public void setNettime(int nettime) {
        this.nettime = nettime;
    }
}
