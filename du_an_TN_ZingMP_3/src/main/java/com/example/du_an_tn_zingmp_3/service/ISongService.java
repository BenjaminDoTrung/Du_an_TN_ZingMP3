package com.example.du_an_tn_zingmp_3.service;

import com.example.du_an_tn_zingmp_3.model.PlayList;
import com.example.du_an_tn_zingmp_3.model.Songs;

import java.util.List;
import java.util.Optional;

public interface ISongService extends IGeneralService <Songs> {
    Optional<Songs> findByNameSong(String name);
    Iterable<Songs> findAllByNameSong(String name);
    void addPlayList(Long idPlayList, Long idSong);
    Iterable<Songs> searchAllByName(String name);
    List<Songs> searchAllByIdUser(Long idUser);
    List<Songs> findAllByIdPlayList (Long id);
    List<Songs> findAllByNameSinger (String nameSinger);
    List<Songs> findAllByIdSongType (Long id);
}
