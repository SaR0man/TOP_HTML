package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")

public class TestController {

    @GetMapping("/str")
    public String str () {
        return ("Backend message");
    }

    @GetMapping("/sum")
    public int sum (int a, int b) { return a + b; }

    @GetMapping("/subtract")
    public int subtract (int a, int b) { return a - b; }

    @GetMapping("/calc")
    public int calc (int a, int b, String c) {
        int result = 0;
        switch (c) {
            case "+": result = a + b;
            break;
            case "-": result = a - b;
            break;
        }
        return result;
    }

    @GetMapping("/evenOdd")
    public boolean evenOdd (int value) {
        value % 2 == 0? 
    }


}
