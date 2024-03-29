package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.models.Registration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        work.add(new Person("George", 2));
        work.add(new Person("John", 3));
        work.add(new Person("Michael", 4));
        work.add(new Person("John", 5));
        work.add(new Person("Frank", 6));
    }

    ////// Запросы:
    @PostMapping("/registration")
    public String registration(@RequestBody Registration registration) {
        System.out.println("Login:    " + registration.login);
        System.out.println("Password: " + registration.password);
        return "User " + registration.login + " was successfully registered!";
    }

    @GetMapping("/all")
    public List<Person> getAll() {
        return work;
    }

    @GetMapping("/all/{name}")
    public List<Person> getAll(@PathVariable String name) {
        return work.stream().filter(x -> x.getName().equals(name)).collect(Collectors.toList());
    }

    @GetMapping("/add")
    public boolean addUser(@RequestParam(value = "name", required = false, defaultValue = "NoName") String field_name, int id) {
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

    @GetMapping("/createPerson")
    public String createPerson() {
        // Создаем объект класса Person
        Person person = new Person("Иванов", 25, "Мужской", "ivanov@example.com");

        // Выводим информацию о созданном объекте в консоль
        System.out.println(person.toString());

        // Возвращаем сообщение об успешном создании объекта
        return "Объект Person успешно создан.";
    }


}
