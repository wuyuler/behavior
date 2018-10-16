package com.yjt.demo.controller;

import com.yjt.demo.domain.NetData;
import com.yjt.demo.repository.NetDataRepository;
import com.yjt.demo.service.NetDataService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
public class NetDataController {

    @Autowired
    NetDataRepository netDataRepository;
    @Autowired
    NetDataService netDataService;


    @PutMapping(value = "/netdatas/update")
    public void updateData(){
        netDataService.updateData();
    }

    @PostMapping(value = "/netdatas/getAppppp")
    public NetData getNetDataByName(@RequestParam( "appName") String appName ){
       return netDataRepository.findById(appName).orElse(null);
    }

    @PostMapping(value = "/netdatas/getDataByname")
    public Map<String, List> getResultByName(@RequestParam( "appName") String appName ){
        NetData netData = getNetDataByName(appName);
        Map<String,List> map=new HashMap();
        List<String> xValue = Arrays.asList(netDataService.getAllTimes());//将string数组转化为list
        List<Integer> value = new ArrayList<>();
        for (String s:xValue
             ) {
            String s1=netData.getOthers().get(s);
            String[] strings;
            if(s1!=null) {
                strings = s1.split("\\|");
                value.add(strings.length);
            }
            else{
                value.add(0);
            }


        }
        map.put("xValue",xValue);
        map.put("value",value);
        return map;
    }


    @GetMapping(value = "/netdatas")
    public List<NetData> getAllData(){
        return netDataRepository.findAll();

    }

    @GetMapping(value = "/netdatas/getAllAppName")
    public List<String> getAllAppName(){
        List<String> allName = netDataRepository.getAllAppName();

        return   allName;
    }
    @PostMapping(value = "/netdatas/addallapp")
    public void addALlAppName(){
        netDataService.addAllAppName();
    }
}



