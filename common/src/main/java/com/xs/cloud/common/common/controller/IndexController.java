package com.xs.cloud.common.common.controller;

import com.xs.cloud.common.common.service.UserService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public  List<Map> testCity(){
     List<Map> cityList =   userService.testCity();

        return cityList;
    }




}
