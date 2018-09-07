package com.yjt.demo.controller;


import com.sun.xml.internal.bind.v2.model.core.ID;
import com.yjt.demo.enums.UserEnum;
import com.yjt.demo.repository.UserRepository;
import com.yjt.demo.domain.NetUser;
import com.yjt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

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
