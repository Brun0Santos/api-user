package com.dev.api.api.entities;

import com.dev.api.api.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItemEntity {
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItemEntity() {
    }

    @JsonIgnore
    public OrderEntity getOrder() {
        return id.getOrder();
    }

    public void setOrder(OrderEntity order) {
        id.setOrder(order);
    }

    public ProductEntity getProduct() {
        return id.getProduct();
    }

    public void setProduct(ProductEntity product) {
        id.setProduct(product);
    }

    public OrderItemEntity(OrderEntity order, ProductEntity product, Integer quantity, Double price) {
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity orderItemEntity = (OrderItemEntity) o;
        return Objects.equals(id, orderItemEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
}
