package com.yjt.demo.controller;

import com.yjt.demo.repository.TimeAddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeAddController {
    @Autowired
    private TimeAddRepository timeAddRepository;
}
