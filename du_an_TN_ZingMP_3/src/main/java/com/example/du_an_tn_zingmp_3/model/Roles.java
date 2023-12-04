package com.example.du_an_tn_zingmp_3.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Roles() {
    }

    public Roles(String name) {
        this.name = name;
    }

    private String name;
}
