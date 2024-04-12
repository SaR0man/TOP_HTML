package com.example.demo.controllers;

import com.example.demo.models.ProductDTO;
import com.example.demo.services.ProductServices;
import com.example.demo.utils.ApplicationReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class TestController {

    ProductServices productServices;

    @Autowired
    ApplicationReader applicationReader;

    //// Конструктор класса
    public TestController(ProductServices productServices) {
        this.productServices = productServices;
    }

    //// Методы класса
    @PostMapping("/test")
    public void insertData(@RequestBody ProductDTO productDTO) {
        applicationReader.test();
        productServices.create(productDTO);

    }
}
