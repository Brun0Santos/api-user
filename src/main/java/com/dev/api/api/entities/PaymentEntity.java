package com.dev.api.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    @JsonIgnore
    @OneToOne
    @MapsId
    private OrderEntity order;

    public PaymentEntity() {
    }

    public PaymentEntity(Integer id, LocalDateTime localDateTime, OrderEntity order) {
        this.id = id;
        this.date = localDateTime;
        this.order = order;
    }


    public Integer getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public OrderEntity getOrder() {
        return order;
    }
}
