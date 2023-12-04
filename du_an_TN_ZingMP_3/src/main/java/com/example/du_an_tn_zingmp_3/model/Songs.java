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
    private SongTypes id_SongTypes;
}
