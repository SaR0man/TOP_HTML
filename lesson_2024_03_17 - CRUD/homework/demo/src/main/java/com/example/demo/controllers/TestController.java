package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.models.Registration;
import org.springframework.http.ResponseEntity;
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

    ////// Методы CRUD
    @GetMapping("/getAll")
    public List<Person> getAll() {
        return mainLib;
    }

    @PostMapping("/addPerson")
    public String addPerson(@RequestBody Person person) {
        // Проверяем обязательные поля
        if (
                person.getName() == null || person.getName().isEmpty() ||
                person.getAge() <= 0 ||
                person.getGender() == null || person.getGender().isEmpty() ||
                person.getEmail() == null || person.getEmail().isEmpty()) {
            return "The fields are filled in incorrectly";
        }

        mainLib.add(person);
        return "The person is added successfully";
    }

    @PutMapping("/updatePerson/{id}")
    public boolean updatePerson(@PathVariable int id, @RequestBody Person updatedPerson) {
        Person personToUpdate = findPersonById(id);
        if (personToUpdate != null) {
            // Обновляем данные найденного объекта Person
            updatedPerson.setId(id); // сохраняем тот же id
            mainLib.set(mainLib.indexOf(personToUpdate), updatedPerson);
            return true;
        } else {
            return false; // Если пользователь с заданным ID не найден
        }
    }

    @DeleteMapping("/deletePerson")
    public boolean deletePerson(@RequestParam int id) {
        Person personToDelete = findPersonById(id);
        if (personToDelete != null) {
            // Удаляем найденный объект Person
            mainLib.remove(personToDelete);
            return true;
        } else {
            return false; // Если пользователь с заданным ID не найден
        }
    }

    // Метод для поиска объекта Person по id
    private Person findPersonById(int id) {
        for (Person person : mainLib) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null; // Если пользователь с заданным ID не найден
    }
}
