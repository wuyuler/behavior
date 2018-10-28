package com.yjt.demo.controller;


import com.yjt.demo.service.orignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class orignController {
    @Autowired
    private com.yjt.demo.service.orignService orignService;
    @GetMapping(value = "/data")

    public void insert()
    {
        orignService.save();
    }
    @GetMapping(value = "/url")
    public void geturl(){orignService.sumUrl();}


}
