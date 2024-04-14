package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    private static Singleton instance = null;
    static int index = 1;

    private List<Integer> data;

    private Singleton() {
        data = new ArrayList<>();
    }

    public static Singleton getInstance() {
        System.out.print("Index: " + index++ + ". ");
        if (instance == null) {
            instance = new Singleton();
            System.out.println("создание объекта");
        } else System.out.println("объект уже был создан");
        return instance;
    }

    public List<Integer> getData() {
        return data;
    }
}
