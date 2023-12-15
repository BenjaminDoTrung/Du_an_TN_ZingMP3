package com.example.du_an_tn_zingmp_3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Data
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSong;
    private String singer;
    private String author;
    private LocalDate date;
    private String url_img;
    private String description;
    private String file_song;
    private int count_like;
    private boolean likes;
    @ManyToOne
    private User user;
    @ManyToOne
    private SongTypes id_SongTypes;
    @ManyToMany
    private List<PlayList> playLists;

    public Songs(String nameSong, String singer, String author, LocalDate date, String url_img, String description, String file_song, User user, SongTypes id_SongTypes) {
        this.nameSong = nameSong;
        this.singer = singer;
        this.author = author;
        this.date = date;
        this.url_img = url_img;
        this.description = description;
        this.file_song = file_song;
        this.user = user;
        this.id_SongTypes = id_SongTypes;
    }

    public Songs() {
    }
}
