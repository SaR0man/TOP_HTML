package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReader {

    @Value("${db.url}")
    public static String dbPath;
    @Value("${db.username}")
    public static String dbUsername;
    @Value("${db.password}")
    public static String dbPassword;

    public void test() {
        System.out.println(dbPath);
        System.out.println(dbUsername);
        System.out.println(dbPassword);
    }

    //// геттеры + сеттеры:
    public static String getDbPath() {
        return dbPath;
    }

    public static void setDbPath(String dbPath) {
        ApplicationReader.dbPath = dbPath;
    }

    public static String getDbUsername() {
        return dbUsername;
    }

    public static void setDbUsername(String dbUsername) {
        ApplicationReader.dbUsername = dbUsername;
    }

    public static String getDbPassword() {
        return dbPassword;
    }

    public static void setDbPassword(String dbPassword) {
        ApplicationReader.dbPassword = dbPassword;
    }
}
