package com.dev.api.api.config;

import com.dev.api.api.entities.*;
import com.dev.api.api.entities.enums.OrderStatus;
import com.dev.api.api.repository.*;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


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

        CategoryEntity categoryElectronics = new CategoryEntity(null, "Electronics");
        CategoryEntity categoryBooks = new CategoryEntity(null, "Books");
        CategoryEntity categoryComputers = new CategoryEntity(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(categoryElectronics, categoryBooks, categoryComputers));

        ProductEntity p1 = new ProductEntity(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        ProductEntity p2 = new ProductEntity(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        ProductEntity p3 = new ProductEntity(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        ProductEntity p4 = new ProductEntity(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        ProductEntity p5 = new ProductEntity(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        p1.getCategories().add(categoryBooks);
        p2.getCategories().add(categoryElectronics);
        p2.getCategories().add(categoryComputers);
        p3.getCategories().add(categoryComputers);
        p4.getCategories().add(categoryComputers);
        p5.getCategories().add(categoryBooks);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        OrderItemEntity orderItemEntityOne = new OrderItemEntity(orderOne, p1, 2, p1.getPrice());
        OrderItemEntity orderItemEntityTwo = new OrderItemEntity(orderOne, p3, 1, p3.getPrice());
        OrderItemEntity orderItemEntityThree = new OrderItemEntity(orderTwo, p3, 2, p3.getPrice());
        OrderItemEntity orderItemEntityFour = new OrderItemEntity(orderTwo, p5, 2, p5.getPrice());
        OrderItemEntity orderItemEntityFive = new OrderItemEntity(orderOne, p2, 2, p2.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItemEntityOne, orderItemEntityTwo, orderItemEntityThree,
                orderItemEntityFour, orderItemEntityFive));

        PaymentEntity payment = new PaymentEntity(null, LocalDateTime.now().plusHours(8), orderTwo);
        orderTwo.setPayment(payment);

        orderRepository.save(orderOne);
    }
}
