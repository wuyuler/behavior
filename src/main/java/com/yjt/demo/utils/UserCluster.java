package com.yjt.demo.utils;

import com.yjt.demo.domain.Userbean;
import com.yjt.demo.domain.XYbean;

import java.util.List;


public class UserCluster extends KMeansClustering<Userbean> {

    @Override
    public double similarScore(Userbean o1, Userbean o2) {
        double distance = Math.sqrt((o1.getAge() - o2.getAge()) * (o1.getAge() - o2.getAge()) + (o1.getEdu() - o2.getEdu()) * (o1.getEdu() - o2.getEdu())+ (o1.getIncome() - o2.getIncome()) * (o1.getIncome() - o2.getIncome())+ (o1.getJob() - o2.getJob()) * (o1.getJob() - o2.getJob())+ (o1.getNettime() - o2.getNettime()) * (o1.getNettime() - o2.getNettime()));
        return distance * -1;
    }

    @Override
    public boolean equals(Userbean o1, Userbean o2) {

        return o1.getEdu() == o2.getEdu() && o1.getAge() == o2.getAge() && o1.getIncome() == o2.getIncome() && o1.getNettime() == o2.getNettime() && o1.getJob() == o2.getJob();
    }

    @Override
    public Userbean getCenterT(List<Userbean> list) {
        int age=0;
        int job=0;
        int income=0;
        int nettime=0;
        int edu=0;
        try {
            for (Userbean u : list) {
                age += u.getAge();
                job += u.getJob();
                income+=u.getIncome();
                nettime+=u.getNettime();
                edu+=u.getEdu();
            }
            age = age / list.size();
            job = job / list.size();
            income=income/list.size();
            nettime=nettime/list.size();
            edu=edu/list.size();
        } catch(Exception e) {

        }
        return new Userbean(age,job,income,edu,nettime);

    }
}
