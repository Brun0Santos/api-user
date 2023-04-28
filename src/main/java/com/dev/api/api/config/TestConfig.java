package com.dev.api.api.config;

import com.dev.api.api.entities.OrderEntity;
import com.dev.api.api.entities.UserEntity;
import com.dev.api.api.repository.OrderRepository;
import com.dev.api.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        LocalDateTime localDateTime = LocalDateTime.parse(LocalDateTime.now().format(formatter));
        UserEntity userOne = new UserEntity(null, "Marcos Viws",
                "marcos@gmail.com", "98983918371", "1q2w3e4r");

        UserEntity useTwo = new UserEntity(null, "Lucas Vilela",
                "Lucas@gmail.com", "98972019471", "1q2w3e4r");
        userRepository.saveAll(Arrays.asList(userOne, useTwo));


        OrderEntity orderOne = new OrderEntity(null, LocalDateTime.now(), userOne);
        OrderEntity orderTwo = new OrderEntity(null, LocalDateTime.now(), useTwo);

        orderRepository.saveAll(Arrays.asList(orderOne, orderTwo));
    }
}
