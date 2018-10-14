package com.yjt.demo.controller;


import com.sun.xml.internal.bind.v2.model.core.ID;
import com.yjt.demo.domain.Time_add;
import com.yjt.demo.domain.Time_start;
import com.yjt.demo.enums.UserEnum;
import com.yjt.demo.repository.ProcessNameRepository;
import com.yjt.demo.repository.TimeAddRepository;
import com.yjt.demo.repository.TimeStartRepository;
import com.yjt.demo.repository.UserRepository;
import com.yjt.demo.domain.NetUser;
import com.yjt.demo.service.ProcessNameService;
import com.yjt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TimeStartRepository timeStartRepository;
    @Autowired
    private TimeAddRepository timeAddRepository;
    @Autowired
    private ProcessNameService processNameService;

    //插入所有数据
    @GetMapping("/users/insertAllData")
    public void insertAllData(){
        userService.insertAllData();
    }
    @GetMapping(value = "/users/timeValue/insert")
    public void insertTimeValue(){//测试插入一条,在特定时间以及相关行为的数据
        processNameService.insertDataFromFile();

    }

    @GetMapping(value = "/users")
    public List<NetUser> userList(){return userRepository.findAll();}

    @GetMapping(value = "/users/getGender")
    public List<Map>  getGender(){
       return userService.getResult("gender");
    }

    @GetMapping(value = "/users/getEdu")
    public List<Map> getEdu(){
        return userService.getResult(UserEnum.EDU.getField());
    }
    @GetMapping(value = "/users/getJob")
    public List<Map> getJob(){
        return userService.getResult(UserEnum.JOB.getField());
    }
    @GetMapping(value = "/users/getIncome")
    public List<Map> getIncome(){

        return userService.getResult(UserEnum.INCOME.getField());
    }
    @GetMapping(value = "/users/getProvince")
    public List<Map> getProvince(){
        return userService.getResult(UserEnum.PROVINCE.getField());
    }
    @GetMapping(value = "/users/getCity")
    public List<Map> getCity(){
        return userService.getResult(UserEnum.CITY.getField());
    }
    @GetMapping(value = "/users/getIsCity")
    public List<Map> getIsCity(){
        return userService.getResult(UserEnum.IS_CITY.getField());
    }

    @GetMapping(value = "/users/test")
    public List<String> test(){
        return userService.getOneColumn("M");
    }
    @PostMapping(value = "/users")
    public NetUser netUserAdd(NetUser netUser){
        return userRepository.save(netUser);
    }
}
