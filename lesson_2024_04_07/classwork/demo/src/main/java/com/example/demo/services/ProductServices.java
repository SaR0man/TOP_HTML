package com.example.demo.services;

import com.example.demo.models.ProductDTO;
import com.example.demo.utils.ApplicationReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductServices {

    @Autowired
    ApplicationReader applicationReader;
    public void create(ProductDTO productDTO) {

        System.out.println(applicationReader.getDbPath());
        System.out.println(applicationReader.getDbUsername());
        System.out.println(applicationReader.getDbPassword());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Connect success!");
//            String url = "jdbc:mysql://localhost:3306/CW20240406_CompanyStaff";
//            String username = "root";
//            String password = "qwerty";

            try(Connection connection = DriverManager.getConnection(
                    applicationReader.dbPath,
                    applicationReader.dbUsername,
                    applicationReader.dbPassword))
            {
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
