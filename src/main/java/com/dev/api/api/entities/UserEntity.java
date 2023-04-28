package com.dev.api.api.entities;

import com.dev.api.api.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String name;
    private String number;
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<OrderEntity> orders = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public UserEntity() {

    }

    public UserEntity(Integer id, String email, String name, String number, String password, OrderStatus status) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.number = number;
        this.password = password;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
