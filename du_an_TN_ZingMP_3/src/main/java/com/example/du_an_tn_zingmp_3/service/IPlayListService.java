package com.example.du_an_tn_zingmp_3.service;

import com.example.du_an_tn_zingmp_3.model.PlayList;

import java.util.List;
import java.util.Optional;

public interface IPlayListService extends IGeneralService <PlayList> {
    Optional<PlayList> findByName(String name);
    void deleteSongInPlaylist(Long idSong, Long idPlaylist);
    List<PlayList> finAllByIdUser (Long idUser);
}
