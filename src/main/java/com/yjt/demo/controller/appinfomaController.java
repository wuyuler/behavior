package com.yjt.demo.controller;

import com.yjt.demo.domain.appinfoma;
import com.yjt.demo.repository.appinfomaRepository;
import com.yjt.demo.utils.AppCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class appinfomaController {

    @Autowired
    appinfomaRepository appinfomaRepo;

    @GetMapping("/appinfoma/kmeans")
    void kmeans(){
        List<appinfoma> list=appinfomaRepo.findAll();
        AppCluster appCluster=new AppCluster();
        appCluster.setK(7);
        for(appinfoma appbean:list)
            appCluster.addRecord(appbean);
        long a = System.currentTimeMillis();
        List<List<appinfoma>> cresult = appCluster.clustering();
        List<appinfoma> center = appCluster.getClusteringCenterT();
        for(int i=0;i<cresult.size();i++){
            System.out.println("第"+(i+1)+"类"+"=================================");
            for(int j=0;j<cresult.get(i).size();j++){
                appinfoma app=cresult.get(i).get(j);
                System.out.println(app.toString());
            }

        }

        for(int i=0;i<center.size();i++){
            System.out.println(center.get(i).toString());
            System.out.println(cresult.get(i).size());
        }

        //System.out.println(JsonUtil.parseJson(center));
        long b = System.currentTimeMillis();
        System.out.println("耗时：" + (b - a) + "ms");
        //new ImgUtil().drawXYbeans(width, height, cresult, "d:/2.png", 0, 0);
    }

}
