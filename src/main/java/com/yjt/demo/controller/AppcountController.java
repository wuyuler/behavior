package com.yjt.demo.controller;

import com.yjt.demo.domain.Appcount;
import com.yjt.demo.repository.AppcountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AppcountController {
    @Autowired
    AppcountRepository appcountRepository;

    @PostMapping("appcount/getTopApp")
    public Map<String,List> getTopApp(@RequestParam("userid") String userid,@RequestParam("num")int num){
        List<Appcount> list=appcountRepository.findAllByUseridOrderByCountDesc(userid);
        List<String> appname=new ArrayList<>();
        List<Long> times=new ArrayList<>();
        for(Appcount appcount:list){
            if(num==0)break;
            appname.add(appcount.getAppname());
            times.add(appcount.getCount());
            num--;
        }

        Map<String,List> map=new HashMap<>();
        map.put("xValue",appname);
        map.put("yValue",times);
        return map;
    }
    @PostMapping("appcount/getJobOfApp")
    public List<Map> getJobApp(@RequestParam("appname") String appname){
        List<Appcount> list=appcountRepository.findAllByAppname(appname);
        Map<String,Integer> map=new HashMap<>();//身份及对应人数
        for(Appcount appcount:list){
            if(map.containsKey(appcount.getJob()))
                map.put(appcount.getJob(),map.get(appcount.getJob())+1);
            else map.put(appcount.getJob(),1);
        }
        List<Map> result=new ArrayList<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            Map map1=new HashMap<>();
            map1.put("name",entry.getKey());
            map1.put("value",entry.getValue());
            result.add(map1);
        }
        return result;
    }
}
