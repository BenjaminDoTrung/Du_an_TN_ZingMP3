package com.example.du_an_tn_zingmp_3.service.impl;

import com.example.du_an_tn_zingmp_3.model.SongTypes;
import com.example.du_an_tn_zingmp_3.repository.ISongTypeRepository;
import com.example.du_an_tn_zingmp_3.service.ISongTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongTypeService implements ISongTypeService {
    @Autowired
    private ISongTypeRepository iSongTypeRepository;

    @Override
    public Iterable<SongTypes> findAll() {
        return iSongTypeRepository.findAll();
    }

    @Override
    public Optional<SongTypes> findById(Long id) {
        return iSongTypeRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        iSongTypeRepository.deleteById(id);
    }

    @Override
    public void save(SongTypes songTypes) {
        iSongTypeRepository.save(songTypes);
    }
}
