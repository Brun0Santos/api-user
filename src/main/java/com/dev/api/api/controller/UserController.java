package com.dev.api.api.controller;

import com.dev.api.api.entities.UserEntity;
import com.dev.api.api.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices services;

    @GetMapping
    public ResponseEntity<List<UserEntity>> returnALlUsers() {
        List<UserEntity> allUsers = services.getAllUsers();
        return ResponseEntity.ok().body(allUsers);
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> returnUserFromId(@PathVariable("id") Integer id) {
        return services.getUserFromID(id);
    }
}
