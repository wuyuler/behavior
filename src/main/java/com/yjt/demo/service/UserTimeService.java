package com.yjt.demo.service;


import com.yjt.demo.domain.UserTime;
import com.yjt.demo.enums.FileEnum;
import com.yjt.demo.repository.UserTimeRepository;
import com.yjt.demo.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserTimeService {
    @Autowired
    private UserTimeRepository userTimeRepository;

    //通过日期(字符串格式yyyy-MM-dd)获取所有数据
    public List<UserTime> getAllByStartDate(Date date){
        //Date date = TimeUtils.strToDate(s);
        List<UserTime> list= userTimeRepository.findAllByStartDate(date);
        return list;
    }

    //通过日期(字符串格式yyyy-MM-dd)获取一个map(用户id,上网时间)
    public HashMap<String,Integer> getuserIdAndTime(Date date){
        List<UserTime> list=getAllByStartDate(date);
        HashMap<String,Integer> map_useridAndTime=new HashMap<>();
        for(int i=0;i<list.size();i++){
            if (!map_useridAndTime.containsKey(list.get(i).getUserId())){
                map_useridAndTime.put(list.get(i).getUserId(),list.get(i).getLenTime());
            }
            else {
                map_useridAndTime.put(list.get(i).getUserId(),map_useridAndTime.get(list.get(i).getUserId())+list.get(i).getLenTime());
            }
        }
        return map_useridAndTime;

    }

    //通过日期(字符串格式yyyy-MM-dd)获取当天上网时长0-24各个区间的人数
    public Map<Integer,Integer> getMapTimeAndNum(Date date){
        Map<String,Integer>IdAndTime= getuserIdAndTime(date);
        HashMap<Integer,Integer> timeAndNum=new HashMap<>();
        for(int i=0;i<=23;i++)
            timeAndNum.put(i,0);
        for(Integer v:IdAndTime.values()){
            if (timeAndNum.containsKey(v/3600))
            timeAndNum.put(v/3600,timeAndNum.get(v/3600)+1);
            else
                timeAndNum.put(23,timeAndNum.get(23)+1);
        }
    return timeAndNum;
    }

    public void InsertAllData(){
        String basePath = FileEnum.basepath;
        File file1=new File(basePath);
        File[] timeFiles = file1.listFiles();

        for(File f:timeFiles){//遍历所有日期
            File[] dataFiles = f.listFiles();//日期是固定的,可以考虑获取后重复使用
            int count=0;
            List<UserTime> list_usertime=new ArrayList<>();
            for(File f_data:dataFiles){//遍历某个日期所有用户的数据
                count++;

                System.out.println(count);

                //创建一个User_time对象用于填充
                //通过文件名获取user_id,start_date,start_time
                UserTime user_time=new UserTime();
                user_time.setUserId(f_data.getName().substring(0,32));
                System.out.println(f_data.getName().substring(33,43));
                System.out.println(f_data.getName().substring(44,52));
                Date date= TimeUtils.strToDate(f_data.getName().substring(33,43));
                Time time=TimeUtils.strToTime(f_data.getName().substring(44,52));

                user_time.setStartDate(date);
                user_time.setStartTime(time);

                //从一个txt文件的每一条中获取一个time_add对象
                InputStreamReader reader = null;
                BufferedReader bufferedReader =null;
                try {
                    reader = new InputStreamReader(new FileInputStream(f_data));
                    bufferedReader =new BufferedReader(reader);
                    //第一行格式Last<=>7762
                    String firstline=bufferedReader.readLine();
                    String str_len_time=firstline.substring(7);
                    int len_time=Integer.parseInt(str_len_time);
                    user_time.setLenTime(len_time);
                    reader.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                list_usertime.add(user_time);
            }
        userTimeRepository.saveAll(list_usertime);


        }
    }
}
