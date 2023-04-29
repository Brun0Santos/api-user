package com.dev.api.api.controller;

import com.dev.api.api.entities.ProductEntity;
import com.dev.api.api.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServices services;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> returnALlUsers() {
        List<ProductEntity> allUsers = services.getAllUsers();
        return ResponseEntity.ok().body(allUsers);
    }

    @GetMapping("/{id}")
    public Optional<ProductEntity> returnUserFromId(@PathVariable("id") Integer id) {
        return services.getUserFromID(id);
    }
}
