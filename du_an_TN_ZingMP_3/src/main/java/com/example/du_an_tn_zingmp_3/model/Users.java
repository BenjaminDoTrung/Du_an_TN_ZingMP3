package com.example.du_an_tn_zingmp_3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Table
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String url_img;
    private LocalDate dayOfBirth;
    private String phone;
    private String fullName;
    @ManyToOne
    private Roles roles;

}
