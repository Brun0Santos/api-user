package com.dev.api.api.services;


import com.dev.api.api.entities.OrderEntity;
import com.dev.api.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    @Autowired
    OrderRepository repository;

    public List<OrderEntity> getAllUsers() {
        return repository.findAll();
    }

    public Optional<OrderEntity> getUserFromID(Integer id) {
        Optional<OrderEntity> user = repository.findById(id);
        user.orElseThrow();
        return user;
    }
}

