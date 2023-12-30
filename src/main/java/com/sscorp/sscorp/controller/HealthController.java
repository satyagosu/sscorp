package com.sscorp.sscorp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping(value="/health",method= RequestMethod.GET)
    public String HeatlhCheck(){
        return "ss-corp app is up and running!!!";
    }
}