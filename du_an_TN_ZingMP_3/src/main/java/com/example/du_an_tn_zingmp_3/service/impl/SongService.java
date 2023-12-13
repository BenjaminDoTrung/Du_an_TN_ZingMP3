package com.example.du_an_tn_zingmp_3.service.impl;

import com.example.du_an_tn_zingmp_3.model.Songs;
import com.example.du_an_tn_zingmp_3.repository.ISongRepository;
import com.example.du_an_tn_zingmp_3.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService implements ISongService {
   @Autowired
    private ISongRepository iSongRepository;

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
}
