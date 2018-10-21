package com.yjt.demo.controller;


import com.yjt.demo.domain.UserTime;
import com.yjt.demo.repository.UserTimeRepository;
import com.yjt.demo.service.UserTimeService;
import com.yjt.demo.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserTimeController {

    @Autowired
    private UserTimeRepository userTimeRepository;
    @Autowired
    private UserTimeService userTimeService;

    @GetMapping("/usertime/num_day_24")
    public void getNumDay24(){

    }
    @GetMapping("/usertime/insertAllData")
    public void insertAllData(){
        userTimeService.InsertAllData();
    }

    @PostMapping("/usertime/getMapTimeAndNum")
    public Map<String,List> getMapTimeAndNum(@RequestParam("date") String s){
        Date date=TimeUtils.strToDate(s);
        Map<Integer,Integer> map=userTimeService.getMapTimeAndNum(date);
        //时间段
        List<String> time=new ArrayList<>();
        //时间段对应的上网人数
        List<Integer>num=new ArrayList<>();
        for(int i=0;i<24;i++){
            int begin=i;
            int end=i+1;
            time.add(begin+"-"+end);
            num.add(map.get(i));
        }
        Map<String,List> map1=new HashMap<>();
        map1.put("xValue",time);
        map1.put("yValue",num);
        return map1;
    }


}
