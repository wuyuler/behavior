package com.yjt.demo.service;

import com.yjt.demo.domain.ProcessName;
import com.yjt.demo.domain.Time_add;
import com.yjt.demo.domain.Time_start;
import com.yjt.demo.repository.ProcessNameRepository;
import com.yjt.demo.utils.RegexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProcessNameService {

    @Autowired
    private ProcessNameRepository processNameRepository;

    public void insertDataFromFile(){
        String basePath = "C:\\Users\\Administrator\\Desktop\\data\\behavior";
        File file1=new File(basePath);
        File[] timeFiles = file1.listFiles();

        List<ProcessName> processNameList=new ArrayList<>();
        Map<String,String> PNmap=new HashMap<>();
        for(File f:timeFiles){//遍历所有日期
            File[] dataFiles = f.listFiles();//日期是固定的,可以考虑获取后重复使用
            int count=0;
            for(File f_data:dataFiles){//遍历某个日期所有用户的数据
                count++;
                System.out.println(count);
                InputStreamReader reader = null;
                BufferedReader bufferedReader =null;
                try {
                    reader = new InputStreamReader(new FileInputStream(f_data));
                    bufferedReader =new BufferedReader(reader);
                    String line;
                    //跳过前两行
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    while ((line=bufferedReader.readLine())!=null){
                        List<String> list=RegexUtils.getPrecessName(line);
                        if(!list.get(0).equals("NULL")){
                            if(!PNmap.containsKey(list.get(0))){
                                PNmap.put(list.get(0),list.get(1));
                            }
                        }
                    }
                    reader.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

        }
        for(Map.Entry<String,String> entry:PNmap.entrySet()){
            ProcessName processName=new ProcessName();
            processName.setProcess_name(entry.getKey());
            processName.setAppName(entry.getValue());
            processNameList.add(processName);
        }
        processNameRepository.saveAll(processNameList);
        System.out.println("完成");

    }

}
