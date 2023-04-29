package com.dev.api.api.services;


import com.dev.api.api.entities.ProductEntity;
import com.dev.api.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    ProductRepository repository;

    public List<ProductEntity> getAllUsers() {
        return repository.findAll();
    }

    public Optional<ProductEntity> getUserFromID(Integer id) {
        Optional<ProductEntity> user = repository.findById(id);
        user.orElseThrow();
        return user;
    }
}

