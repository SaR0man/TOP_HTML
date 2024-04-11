package com.example.demo.controllers;

import com.example.demo.models.ProductDTO;
import com.example.demo.services.ProductServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class TestController {

    ProductServices productServices;

    //// Конструктор класса
    public TestController(ProductServices productServices) {
        this.productServices = productServices;
    }

    //// Методы класса
    @PostMapping("/test")
    public void insertData(@RequestBody ProductDTO productDTO) {
        productServices.create(productDTO);

    }
}
