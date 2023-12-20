package com.example.du_an_tn_zingmp_3.service.impl;

import com.example.du_an_tn_zingmp_3.model.PlayList;
import com.example.du_an_tn_zingmp_3.model.Songs;
import com.example.du_an_tn_zingmp_3.repository.IPlayListRepository;
import com.example.du_an_tn_zingmp_3.service.IPlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayListService implements IPlayListService {
    @Autowired
    private IPlayListRepository iPlayListRepository;
    @Override
    public Iterable<PlayList> findAll() {
        return iPlayListRepository.findAll();
    }

    @Override
    public Optional<PlayList> findById(Long id) {
        return iPlayListRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        iPlayListRepository.deleteById(id);
    }

    @Override
    public void save(PlayList playList) {
        iPlayListRepository.save(playList);
    }

    @Override
    public Optional<PlayList> findByName(String name) {
        return iPlayListRepository.findByNamePlayList(name);
    }

    @Override
    public void deleteSongInPlaylist(Long idSong, Long idPlaylist) {
        PlayList playList = findById(idPlaylist).get();
        for (Songs song: playList.getSongsList()) {
            if (song.getId() == idSong){
                playList.getSongsList().remove(song);
                break;
            }
        }
    }
}
