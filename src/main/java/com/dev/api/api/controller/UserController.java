package com.dev.api.api.controller;

import com.dev.api.api.entities.UserEntity;
import com.dev.api.api.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<UserEntity> insertUser(@RequestBody UserEntity user) {
        services.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> delete(@PathVariable Integer id) {
        services.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> update(@PathVariable Integer id, @RequestBody UserEntity dataUser) {
        services.updateUser(id, dataUser);
        return ResponseEntity.ok().body(dataUser);
    }
}
