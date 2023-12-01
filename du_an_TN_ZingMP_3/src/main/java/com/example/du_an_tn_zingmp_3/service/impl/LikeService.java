package com.example.du_an_tn_zingmp_3.service.impl;

import com.example.du_an_tn_zingmp_3.model.Likes;
import com.example.du_an_tn_zingmp_3.repository.ILikeRepository;
import com.example.du_an_tn_zingmp_3.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService implements ILikeService {
    @Autowired
    private ILikeRepository iLikeRepository;

    @Override
    public Iterable<Likes> findAll() {
        return iLikeRepository.findAll();
    }

    @Override
    public Optional<Likes> findById(Long id) {
        return iLikeRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        iLikeRepository.deleteById(id);
    }

    @Override
    public void save(Likes likes) {
        iLikeRepository.save(likes);
    }
}
