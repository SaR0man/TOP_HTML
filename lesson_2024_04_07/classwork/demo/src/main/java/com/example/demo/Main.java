package com.example.demo;

import com.example.demo.models.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton3 = Singleton.getInstance();
        Singleton singleton4 = Singleton.getInstance();
        Singleton singleton5 = Singleton.getInstance();

        singleton.getData().add(1);
        singleton2.getData().add(2);
        singleton3.getData().add(3);
        singleton4.getData().add(4);
        singleton5.getData().add(5);

        for (int i = 0; i < singleton5.getData().size(); i++) {
            System.out.print(singleton.getData().get(i) + " ");
        }
    }
}
