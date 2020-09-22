package com.xs.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider-8000")
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "/provider-8000/index";
    }




}
