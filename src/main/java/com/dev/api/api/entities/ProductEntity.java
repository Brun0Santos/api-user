package com.dev.api.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    @ManyToMany
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private final Set<CategoryEntity> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItemEntity> items = new HashSet<>();

    public ProductEntity() {
    }

    public ProductEntity(Integer id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    @JsonIgnore
    public Set<OrderEntity> getOrders() {
        Set<OrderEntity> set = new HashSet<>();
        for (OrderItemEntity x : items) {
            set.add(x.getOrder());
        }
        return set;
    }
}
