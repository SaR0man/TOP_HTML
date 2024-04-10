package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@RestController
@RequestMapping("/api")

public class TestController {
    @GetMapping("/test")
    public void test() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Connect success!");
            String url = "jdbc:mysql://localhost:3306/CW20240406_CompanyStaff";
            String username = "root";
            String password = "qwerty";

            Statement statement;
            try(Connection connection = DriverManager.getConnection(url, username, password)) {
                statement = connection.createStatement();

            String insertQuery = """
                    INSERT INTO Products (ProductName, Price) VALUES
                    ('Potato', 60),
                    ('Tomatoes', 45),
                    ('Carrot', 75);
                    """;

                int insertRow = statement.executeUpdate(insertQuery);
                System.out.println("** " + insertRow + " rows were added.");

            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
