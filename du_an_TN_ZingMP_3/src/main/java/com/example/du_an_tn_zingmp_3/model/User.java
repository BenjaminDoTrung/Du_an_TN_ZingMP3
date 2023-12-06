package com.example.du_an_tn_zingmp_3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @Column(nullable = false)
    private String confirmedPassword;
    private String url_img;
    private LocalDate dayOfBirth;
    private String phone;
    private String userName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Roles> roles;
    private boolean enabled = true;

    public User(String password, String confirmedPassword, String userName) {
        this.password = password;
        this.confirmedPassword = confirmedPassword;
        this.userName = userName;
    }

    public User(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public User() {
    }

}
