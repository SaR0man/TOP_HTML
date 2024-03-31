package com.example.demo.models;

import java.util.Date;

public class Person {
    private static int nextId = 1; // статическая переменная для следующего доступного ID
    private int id;
    private String name;
    private int age;
    private String phone;
    private Date birth;
    private String gender;
    private String email;

    //// Конструкторы

    public Person() {
        this.id = nextId++;
    }
    public Person(String name, int age, String gender, String email) {
        this.id = nextId++; // присваиваем текущее значение nextId и увеличиваем его на 1
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Person(String name, int age, String gender, String email, String phone, Date birth) {
        this(name, age, gender, email); // вызываем основной конструктор для обязательных полей
        this.phone = phone;
        this.birth = birth;
    }

    //// Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //// toString
    @Override
    public String toString() {
        return "Person{" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", birth=" + birth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
