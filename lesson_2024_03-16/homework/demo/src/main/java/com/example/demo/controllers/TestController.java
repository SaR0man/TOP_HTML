package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")

public class TestController {

    List<String> work;

    public TestController() {
        work = new ArrayList<>();
        work.add("Даша");
        work.add("Маша");
        work.add("Паша");
        work.add("Саша");
        work.add("Глаша");
    }

    @GetMapping("/arr")
    public List<String> arr() {
        return work;
    }

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

    // 1) Клиент отправляет число вернуть true, если оно четное в противном случае - false
    @GetMapping("/evenOdd")
    public boolean evenOdd (double value) {
        return value % 2 == 0;
    }

    // 2) Клиент отправляет число вернуть true если оно положительное в противном случае false
    @GetMapping("/posNeg")
    public boolean posNeg (double value) {
        return value > 0;
    }

    // 2) Клиент отправляет число вернуть true если оно делиться на 10 без остатка в противном случае false
    @GetMapping("/div10")
    public boolean div10 (double value) {
        return value % 10 == 0;
    }


}
