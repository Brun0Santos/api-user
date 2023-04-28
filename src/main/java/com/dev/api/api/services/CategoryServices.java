package com.dev.api.api.services;


import com.dev.api.api.entities.CategoryEntity;
import com.dev.api.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {

    @Autowired
    CategoryRepository repository;

    public List<CategoryEntity> getAllUsers() {
        return repository.findAll();
    }

    public Optional<CategoryEntity> getUserFromID(Integer id) {
        Optional<CategoryEntity> user = repository.findById(id);
        user.orElseThrow();
        return user;
    }
}

