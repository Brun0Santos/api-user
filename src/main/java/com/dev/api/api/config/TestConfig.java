package com.dev.api.api.config;

import com.dev.api.api.entities.CategoryEntity;
import com.dev.api.api.entities.OrderEntity;
import com.dev.api.api.entities.UserEntity;
import com.dev.api.api.entities.enums.OrderStatus;
import com.dev.api.api.repository.CategoryRepository;
import com.dev.api.api.repository.OrderRepository;
import com.dev.api.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        UserEntity userOne = new UserEntity(null, "Marcos Viws",
                "marcos@gmail.com", "98983918371", "1q2w3e4r", OrderStatus.DELIVERED);

        UserEntity useTwo = new UserEntity(null, "Lucas Vilela",
                "Lucas@gmail.com", "98972019471", "1q2w3e4r", OrderStatus.PAID);
        userRepository.saveAll(Arrays.asList(userOne, useTwo));


        OrderEntity orderOne = new OrderEntity(null, LocalDateTime.now(), userOne);
        OrderEntity orderTwo = new OrderEntity(null, LocalDateTime.now(), useTwo);
        orderRepository.saveAll(Arrays.asList(orderOne, orderTwo));

        CategoryEntity categoryOne = new CategoryEntity(null, "Electronics");
        CategoryEntity categoryTwo = new CategoryEntity(null, "Books");
        CategoryEntity categoryThree = new CategoryEntity(null, "Devices");
        categoryRepository.saveAll(Arrays.asList(categoryOne, categoryTwo, categoryThree));
    }
}
