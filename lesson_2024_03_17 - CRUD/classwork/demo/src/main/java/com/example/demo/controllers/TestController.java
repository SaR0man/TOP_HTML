package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")

public class TestController {

    List<String> work;  // поле класса

    public TestController() {  // конструктор, вызывающий метод initList()
        initList();
    }

    private void initList() {  // метод создает и заполняет коллекцию work
        work = new ArrayList<>();
        work.add("Даша");
        work.add("Маша");
        work.add("Паша");
        work.add("Саша");
        work.add("Глаша");
    }

    @GetMapping("/all")
    public List<String> getAll() {
        return work;
    }

    @GetMapping("/add")
    public boolean addUser(String name) {
        work.add(name);
        return true;
    }

    @GetMapping("/clear")
    public boolean removeAll() {
        work.clear();
        return true;
    }


}
