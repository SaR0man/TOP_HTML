package com.example.demo.services;

import com.example.demo.models.ProductDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServices {

    // Метод для создания новой записи в таблице Products:
    public void create(ProductDTO productDTO) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Connect success!");
            String url = "jdbc:mysql://localhost:3306/HW20240406_Products";
            String username = "root";
            String password = "qwerty";

            try(Connection connection = DriverManager.getConnection(url, username, password)) {

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

    // Метод для чтения содержимого таблицы Products
    public List<ProductDTO> read() {
        List<ProductDTO> productList = new ArrayList<>();

        try {
            // Устанавливаем соединение с базой данных
            String url = "jdbc:mysql://localhost:3306/HW20240406_Products";
            String username = "root";
            String password = "qwerty";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                // Выполняем запрос на чтение содержимого таблицы Products
                String selectQuery = "SELECT * FROM Products";
                PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                ResultSet resultSet = preparedStatement.executeQuery();

                // Обрабатываем результат запроса
                while (resultSet.next()) {
                    String productName = resultSet.getString("ProductName");
                    double price = resultSet.getDouble("Price");

                    // Создаем объект ProductDTO для каждой записи и добавляем его в список
                    ProductDTO product = new ProductDTO(productName, price);
                    productList.add(product);
                }

                // Выводим каждый продукт на отдельной строке
                System.out.println("** Reading from table:");
                for (ProductDTO product : productList) {
                    System.out.println("- Product name: " + product.getName() + ", Price: " + product.getPrice());
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return productList;
    }

    // Метод для удаления строки из таблицы Products по id
    public void delete(int id) {
        try {
            // Устанавливаем соединение с базой данных
            String url = "jdbc:mysql://localhost:3306/HW20240406_Products";
            String username = "root";
            String password = "qwerty";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                // Выполняем запрос на удаление строки из таблицы Products по id
                String deleteQuery = "DELETE FROM Products WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, id);
                int rowsDeleted = preparedStatement.executeUpdate();

                // Проверяем, были ли удалены строки
                if (rowsDeleted > 0) {
                    System.out.println("Row with id " + id + " was deleted successfully.");
                } else {
                    System.out.println("No row found with id " + id + ". Nothing was deleted.");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Метод для изменения значений в строке таблицы Products по id
    public void update(int id, String name, double price) {
        try {
            // Устанавливаем соединение с базой данных
            String url = "jdbc:mysql://localhost:3306/HW20240406_Products";
            String username = "root";
            String password = "qwerty";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                // Выполняем запрос на обновление значений в строке таблицы Products по id
                String updateQuery = "UPDATE Products SET ProductName = ?, Price = ? WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, price);
                preparedStatement.setInt(3, id);
                int rowsUpdated = preparedStatement.executeUpdate();

                // Проверяем, были ли обновлены строки
                if (rowsUpdated > 0) {
                    System.out.println("Row with id " + id + " was updated successfully.");
                } else {
                    System.out.println("No row found with id " + id + ". Nothing was updated.");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
