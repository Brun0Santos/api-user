package com.dev.api.api.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime time;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity client;

    public OrderEntity() {
    }

    public OrderEntity(Integer id, LocalDateTime time, UserEntity client) {
        this.id = id;
        this.time = time;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public UserEntity getClient() {
        return client;
    }
}
