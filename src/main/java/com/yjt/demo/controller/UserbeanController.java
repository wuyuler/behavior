package com.yjt.demo.controller;

import com.yjt.demo.domain.NetUser;
import com.yjt.demo.domain.Userbean;
import com.yjt.demo.repository.UserRepository;
import com.yjt.demo.repository.UserbeanRepository;
import com.yjt.demo.utils.KmeansUtils;
import com.yjt.demo.utils.UserCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserbeanController {
    @Autowired
    UserbeanRepository userbeanRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/userbean/insertAlldata")
    public void insertAllData(){
        List<NetUser> list = userRepository.findAll();
        List<Userbean> list1=new ArrayList<>();
        for(NetUser netUser:list){
            Userbean userbean = new Userbean();
            userbean.setUserid(netUser.getId());
            userbean.setAge((2012-netUser.getBirthday())*10);
            userbean.setJob(KmeansUtils.getJob(netUser.getJob()));
            userbean.setEdu(KmeansUtils.getEdu(netUser.getEdu()));
            userbean.setIncome(KmeansUtils.getIncome(netUser.getIncome()));
            list1.add(userbean);

        }
        userbeanRepository.saveAll(list1);
    }

    @GetMapping("/userbean/kmeans")
    public void kmeans(){
        List<Userbean> list=userbeanRepository.findAll();
        UserCluster userCluster=new UserCluster();
        userCluster.setK(4);
        for(Userbean userbean:list)
            userCluster.addRecord(userbean);
        long a = System.currentTimeMillis();
        List<List<Userbean>> cresult = userCluster.clustering();
        List<Userbean> center = userCluster.getClusteringCenterT();
        for(int i=0;i<cresult.size();i++){
            System.out.println("第"+(i+1)+"类"+"=================================");
            for(int j=0;j<cresult.get(i).size();j++){
                Userbean userbean=cresult.get(i).get(j);
                System.out.println(userRepository.findById(userbean.getUserid()).toString()+"nettime:"+userbean.getNettime());
            }
        }

        for(int i=0;i<center.size();i++)
            System.out.println("第"+i+"中心为:"+center.get(i).toString()+"数量"+cresult.get(i).size());
        //System.out.println(JsonUtil.parseJson(center));
        long b = System.currentTimeMillis();
        System.out.println("耗时：" + (b - a) + "ms");
        //new ImgUtil().drawXYbeans(width, height, cresult, "d:/2.png", 0, 0);
    }

}
