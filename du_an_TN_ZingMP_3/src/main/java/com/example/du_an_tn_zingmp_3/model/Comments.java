package com.example.du_an_tn_zingmp_3.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    private Users users;
    @ManyToOne
    private Songs songs;
}
