package com.yjt.demo.service;

import com.yjt.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    //获取一列中所有数据
    public List<String> getOneColumn(String colName){

        List<String> list=new ArrayList<>();

        switch (colName){
            case "gender":list = userRepository.getAllGender();break;
            case "birthday":list=userRepository.getAllDirthday();break;
            case "edu":list=userRepository.getAllEdu();break;
            case "job":list=userRepository.getAllJob();break;
            case "income":list=userRepository.getAllIncome();break;
            case "province":list=userRepository.getAllProvince();break;
            case "is_city":list=userRepository.getAllIsCity();break;
        }

        return list;
    }

    //获取一列中所有属性名(不重复)
    public Set<String> getOneColumnProperty(String colName){

        Set<String> set = new HashSet<>();
        List<String> list=getOneColumn(colName);
        for (String s:list
             ) {
            set.add(s);
        }
        return set;
    }

    //获取一列中某种属性的个数
    public Integer getNumOfProperty(String colName,String ProName){
        List<String> list = getOneColumn(colName);
        Integer sum = 0;
        for (String s:list
             ) {
            if (s.equals(ProName))sum++;
        }
        return sum;
    }

    public List<Map> getResult(String colName){
        List<Map> list=new ArrayList<>();
        //Set<String> property = getOneColumnProperty(colName);
        List<String> list1=getOneColumn(colName);
        Map<String,Integer> map=new HashMap<>();
        for (String s:list1
             ) {
            if(map.get(s)!=null)
            map.put(s,map.get(s)+1);
            else map.put(s,0);
        }
        for (String s:map.keySet()
             ) {
            Map map1=new HashMap();
            map1.put("name",s);
            map1.put("value",map.get(s));
            list.add(map1);
        }
    return list;

    }

}
