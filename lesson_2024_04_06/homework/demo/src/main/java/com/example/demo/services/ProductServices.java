package com.example.demo.services;

import com.example.demo.models.ProductDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ProductServices {
    public void create(ProductDTO productDTO) {

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
                    INSERT INTO Products (ProductName, Price) VALUES (?, ?);
                    """;
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, productDTO.getName());
                preparedStatement.setDouble(2, productDTO.getPrice());

                int insertRow = preparedStatement.executeUpdate();
                System.out.println("** " + insertRow + " rows were added.");

            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
