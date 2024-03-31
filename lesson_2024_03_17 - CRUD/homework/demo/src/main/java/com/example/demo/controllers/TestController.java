package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.models.Registration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("test")

public class TestController {

    //// поле класса
    List<Person> mainLib;

    //// конструктор, вызывающий метод initList()
    public TestController() {  // конструктор, вызывающий метод initList()
        initList();
    }

    //// метод создает коллекцию mainLib и добавляет объект Person
    private void initList() {
        mainLib = new ArrayList<>();
        mainLib.add(new Person("John", 30, "mail", "nameJohn@company.com"));
    }

    @GetMapping("/getAll")
    public List<Person> getAll() {
        return mainLib;
    }

    @PostMapping("/addPerson")
//    public boolean addPerson(String name, int age, String gender, String email, String phone, Date birth) {
//        mainLib.add(new Person(name, age, gender, email, phone, birth));
//        return true;
//    }
    public boolean addPerson(@RequestBody Person person) {
        mainLib.add(person);
        return true;
    }


    @DeleteMapping("/deletePerson")
    public boolean deletePerson(@RequestParam int id) {
        for (int i = 0; i < mainLib.size(); i++) {
            Person person = mainLib.get(i);
            if (person.getId() == id) {
                mainLib.remove(i);
                return true;
            }
        }
        return false; // если пользователь с заданным ID не найден
    }

}
