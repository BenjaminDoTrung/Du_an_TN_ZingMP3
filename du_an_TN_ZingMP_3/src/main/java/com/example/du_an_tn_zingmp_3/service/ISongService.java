package com.example.du_an_tn_zingmp_3.service;

import com.example.du_an_tn_zingmp_3.model.Songs;

import java.util.Optional;

public interface ISongService extends IGeneralService <Songs> {
    Optional<Songs> findByNameSong(String name);
}
