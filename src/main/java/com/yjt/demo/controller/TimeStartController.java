package com.yjt.demo.controller;

import com.yjt.demo.repository.TimeStartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeStartController {
    @Autowired
    private TimeStartRepository timeStartRepository;

}
