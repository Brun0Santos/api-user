package com.dev.api.api.controller;

import com.dev.api.api.entities.CategoryEntity;
import com.dev.api.api.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryServices services;

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> returnALlUsers() {
        List<CategoryEntity> allUsers = services.getAllUsers();
        return ResponseEntity.ok().body(allUsers);
    }

    @GetMapping("/{id}")
    public Optional<CategoryEntity> returnUserFromId(@PathVariable("id") Integer id) {
        return services.getUserFromID(id);
    }
}
