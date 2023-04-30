package com.dev.api.api.services;

import com.dev.api.api.entities.UserEntity;
import com.dev.api.api.execeptions.DatabaseException;
import com.dev.api.api.execeptions.NotFoundException;
import com.dev.api.api.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        return Optional.ofNullable(user.orElseThrow(() -> new NotFoundException("User not found")));
    }

    public UserEntity saveUser(UserEntity user) {
        return repository.save(user);
    }

    public void deleteUser(Integer id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Error when trying to delete user");
        }
    }

    public UserEntity updateUser(Integer id, UserEntity userForm) {
        try {
            UserEntity userFromDatabase = repository.getReferenceById(id);
            UserEntity.updateData(userFromDatabase, userForm);
            return repository.save(userFromDatabase);
        } catch (EntityNotFoundException ex) {
            throw new NotFoundException("User not found");
        }
    }
}

