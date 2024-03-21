package com.example.demo.controllers;

import com.example.demo.models.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")

public class TestController {

    //// поле класса
    List<Person> work;
//    static int id = 1;

    //// конструктор, вызывающий метод initList()
    public TestController() {  // конструктор, вызывающий метод initList()
        initList();
    }

    //// метод создает коллекцию work и добавляет объект Person
    private void initList() {
        work = new ArrayList<>();
        work.add(new Person("John", 1));
    }

    ////// Запросы:
    @GetMapping("/all")
    public List<Person> getAll() {
        return work;
    }

    @GetMapping("/add")
    public boolean addUser(String name, int id) {
        work.add(new Person(name, id));
        return true;
    }

    @GetMapping("/clear")
    public boolean removeAll() {
        work.clear();
        return true;
    }
}
