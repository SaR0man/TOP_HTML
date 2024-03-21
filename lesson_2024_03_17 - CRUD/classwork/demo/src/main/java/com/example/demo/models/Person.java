package com.example.demo.models;

public class Person {
    //// Поля
    private String name;
    private int id;

    //// Конструкторы
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    //// toString
    @Override
    public String toString() {
        return id + ". " + name;
    }

    //// Геттеры + сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
