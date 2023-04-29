package com.dev.api.api.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime localDateTime;
    @OneToOne
    @MapsId
    private OrderEntity order;

    public PaymentEntity() {
    }

    public PaymentEntity(Integer id, LocalDateTime localDateTime, OrderEntity order) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.order = order;
    }


    public Integer getId() {
        return id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public OrderEntity getOrder() {
        return order;
    }
}
