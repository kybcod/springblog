package com.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main1")
public class Controller01 {
    @GetMapping("sub1")
    public void sub1(){
        System.out.println("Controller01.sub1");
    }
}
