package com.example.demo.models;

public class ProductDTO {
    //// Поля:

    private String name;
    private Double price;

    //// Конструкторы:

    public ProductDTO() {
    }

    public ProductDTO(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    //// Геттеры+Сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
