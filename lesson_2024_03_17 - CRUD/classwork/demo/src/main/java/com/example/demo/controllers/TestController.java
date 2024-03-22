package com.example.demo.controllers;

import com.example.demo.models.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
//        work.add(new Person("John", 1));
    }

    ////// Запросы:
    @GetMapping("/all")
    public List<Person> getAll() {
        return work;
    }

    @GetMapping("/add")
    public boolean addUser(@RequestParam(value = "name", required = false) String field_name, int id) {
        if (field_name == null) return false;
        Person person = (Person) work.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (person == null) {
            work.add(new Person(field_name, id));
            return true;
        }
        else return false;
    }

    @GetMapping("/clear")
    public boolean removeAll() {
        work.clear();
        return true;
    }
}
