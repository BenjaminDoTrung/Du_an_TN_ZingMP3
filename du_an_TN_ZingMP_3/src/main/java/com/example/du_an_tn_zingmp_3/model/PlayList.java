package com.example.du_an_tn_zingmp_3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User id_users;
    private String namePlayList;
    @ManyToMany
    private List<Songs> songsList;

    public PlayList(String namePlayList) {
        this.namePlayList = namePlayList;
    }

    public PlayList(User id_users, String namePlayList) {
        this.id_users = id_users;
        this.namePlayList = namePlayList;
    }

    public PlayList() {
    }
}
