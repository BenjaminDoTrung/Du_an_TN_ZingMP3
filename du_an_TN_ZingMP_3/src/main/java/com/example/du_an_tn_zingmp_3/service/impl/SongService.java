package com.example.du_an_tn_zingmp_3.service.impl;

import com.example.du_an_tn_zingmp_3.model.PlayList;
import com.example.du_an_tn_zingmp_3.model.Songs;
import com.example.du_an_tn_zingmp_3.repository.ISongRepository;
import com.example.du_an_tn_zingmp_3.service.IPlayListService;
import com.example.du_an_tn_zingmp_3.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService implements ISongService {
   @Autowired
    private ISongRepository iSongRepository;
   @Autowired
   private IPlayListService iPlayListService;

    @Override
    public Iterable<Songs> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public Optional<Songs> findById(Long id) {
        return iSongRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        iSongRepository.deleteById(id);
    }

    @Override
    public void save(Songs songs) {
        iSongRepository.save(songs);
    }

    @Override
    public Optional<Songs> findByNameSong(String name) {
        return iSongRepository.findByNameSong(name);
    }

    @Override
    public Iterable<Songs> findAllByNameSong(String name) {
        return iSongRepository.findAllByNameSong(name);
    }

    @Override
    public void addPlayList(Long idPlayList, Long idSong) {
        Songs songs = findById(idSong).get();
        PlayList playList = iPlayListService.findById(idPlayList).get();
        songs.getPlayLists().add(playList);
        save(songs);
    }

}
