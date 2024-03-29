package com.example.demo.models;

import java.util.Date;

public class Person {
    private String name;
    private int id;
    private int age;
    private String phone;
    private Date birth;
    private String gender;
    private String email;

    //// Конструкторы

    public Person() {
    }

    public Person(String name, int age, String gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Person(String name, int id, int age, String phone, Date birth, String gender, String email) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.phone = phone;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
    }

    //// Геттеры и сеттеры
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
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", birth=" + birth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
