package com.yjt.demo.service;


import com.yjt.demo.domain.NetData;
import com.yjt.demo.utils.RegexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yjt.demo.repository.NetDataRepository;
import com.yjt.demo.utils.DataFIleUtils;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static com.yjt.demo.utils.DataFIleUtils.readTxtToString;

@Service
public class NetDataService {
    @Autowired
    NetDataRepository netDataRepository;

    public void addAllAppName(){
        Set<String> allAppName = DataFIleUtils.getALlAppName2();
        for (String appName:allAppName
             ) {
            NetData netData=new NetData();
            netData.setAppName(appName);
            netDataRepository.save(netData);
        }
    }

    public String[] getAllTimes(){
       return DataFIleUtils.getAllTime();
    }



    public void updateData(){

        List<NetData> netDataList=netDataRepository.findAll();
        File file1=new File(DataFIleUtils.basePath);
        File[] timeFiles = file1.listFiles();
        for(File f:timeFiles){
            File[] dataFiles = f.listFiles();

            for(File f_data:dataFiles){
                String s =readTxtToString(f_data);
                List<String> appNameByRegex = RegexUtils.getAppNameByRegex(s);
                for (String appName:appNameByRegex
                ) {
                    //遍历单个文件读取到的app名(只在第一次出现时记录在文件中),更新对应时间(f.getName)下,使用该软件的人(f_data.getName().substring(0,32))
                    //同时判断是否已添加,如果已添加,在其后以'|'为分割符追加
                    for (NetData n:netDataList
                         ) {
                        if(n.getAppName().equals(appName)){
                            if(null != n.getOthers().get(f.getName()))
                                n.getOthers().put(f.getName(), n.getOthers().get(f.getName()) + "|" + f_data.getName().substring(0, 32));
                            else n.getOthers().put(f.getName(),f_data.getName().substring(0,32));
                            break;
                        }
                    }
                }
            }

        }

        netDataRepository.saveAll(netDataList);
    }



}
