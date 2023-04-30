package com.dev.api.api.services;

import com.dev.api.api.entities.UserEntity;
import com.dev.api.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    UserRepository repository;

    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    public Optional<UserEntity> getUserFromID(Integer id) {
        Optional<UserEntity> user = repository.findById(id);
        user.orElseThrow();
        return user;
    }

    public UserEntity saveUser(UserEntity user) {
        return repository.save(user);
    }

    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    public UserEntity updateUser(Integer id, UserEntity userForm) {
        UserEntity userFromDatabase = repository.getReferenceById(id);
        UserEntity.updateData(userFromDatabase, userForm);
        return repository.save(userFromDatabase);
    }
}

