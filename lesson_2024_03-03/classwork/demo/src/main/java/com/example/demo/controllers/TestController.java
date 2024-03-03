package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("test")

public class TestController {
    @GetMapping("myTest")
    public String myTest() {
//        System.out.println();
        return ("Hello world!");
    }
}
