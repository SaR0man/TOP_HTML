package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReader {

    @Value("${db.url}")
    public String dbPath;
    @Value("${db.username}")
    public String dbUsername;
    @Value("${db.password}")
    public String dbPassword;

    public void test() {
        System.out.println(dbPath);
        System.out.println(dbUsername);
        System.out.println(dbPassword);
    }

    //// геттеры + сеттеры:
    public String getDbPath() {
        return dbPath;
    }

    public void setDbPath(String dbPath) {
        this.dbPath = dbPath;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }
}
