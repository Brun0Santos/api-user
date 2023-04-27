package com.dev.api.api.config;

import com.dev.api.api.entities.UserEntity;
import com.dev.api.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        UserEntity userOne = new UserEntity(null, "Marcos Viws",
                "marcos@gmail.com", "98983918371", "1q2w3e4r");

        UserEntity useTwo = new UserEntity(null, "Lucas Vilela",
                "Lucas@gmail.com", "98972019471", "1q2w3e4r");
        repository.saveAll(Arrays.asList(userOne, useTwo));
    }
}
