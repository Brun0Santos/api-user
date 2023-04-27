package com.dev.api.api.entities;

import jakarta.persistence.*;

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

    public UserEntity() {

    }

    public UserEntity(Integer id, String email, String name, String number, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.number = number;
        this.password = password;
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
}
