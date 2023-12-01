package com.example.du_an_tn_zingmp_3.service.impl;

import com.example.du_an_tn_zingmp_3.model.Comments;
import com.example.du_an_tn_zingmp_3.repository.ICommentRepository;
import com.example.du_an_tn_zingmp_3.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository iCommentRepository;
    @Override
    public Iterable<Comments> findAll() {
        return iCommentRepository.findAll();
    }

    @Override
    public Optional<Comments> findById(Long id) {
        return iCommentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        iCommentRepository.deleteById(id);
    }

    @Override
    public void save(Comments comments) {
        iCommentRepository.save(comments);
    }
}
