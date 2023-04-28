package com.dev.api.api.controller;

import com.dev.api.api.entities.OrderEntity;
import com.dev.api.api.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderServices services;

    @GetMapping
    public ResponseEntity<List<OrderEntity>> returnALlUsers() {
        List<OrderEntity> allUsers = services.getAllUsers();
        return ResponseEntity.ok().body(allUsers);
    }

    @GetMapping("/{id}")
    public Optional<OrderEntity> returnUserFromId(@PathVariable("id") Integer id) {
        return services.getUserFromID(id);
    }
}
