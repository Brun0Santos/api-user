package com.dev.api.api.controller;

import com.dev.api.api.entities.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<UserEntity> returnALlUsers() {
        return ResponseEntity.ok().body(new UserEntity());
    }
}
