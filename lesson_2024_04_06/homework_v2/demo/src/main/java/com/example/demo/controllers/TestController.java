package com.example.demo.controllers;

import com.example.demo.models.ProductDTO;
import com.example.demo.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class TestController {

    @Autowired
    ProductServices productServices;

    //// Методы класса
    // Метод для добавления новой записи
    @PostMapping("/test")
    public void insertData(@RequestBody ProductDTO productDTO) {
        productServices.create(productDTO);
    }

    // Метод для чтения содержимого таблицы Products и вывода его в консоль
    @GetMapping("/readProducts")
    public void readProducts() {
        productServices.read();
    }

    // Метод для удаления записи по id
    @DeleteMapping("/del/{id}")
    public void deleteProduct(@PathVariable int id) {
        productServices.delete(id);
    }

//    // Метод для изменения значений в строке таблицы Products
//    @PutMapping("/updateProduct/{id}")
//    public void updateProduct(@PathVariable int id,
//                              @RequestParam String name,
//                              @RequestParam double price) {
//        productServices.update(id, name, price);
//    }

    // Метод для изменения значений в строке таблицы Products
    @PutMapping("/updateProduct/{id}")
    public void updateProduct(@PathVariable int id,
                              @RequestBody ProductDTO updatedProduct) {
        productServices.update(id, updatedProduct.getName(), updatedProduct.getPrice());
    }

}
