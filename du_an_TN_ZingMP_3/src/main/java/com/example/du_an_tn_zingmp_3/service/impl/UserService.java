package com.example.du_an_tn_zingmp_3.service.impl;

import com.example.du_an_tn_zingmp_3.model.Users;
import com.example.du_an_tn_zingmp_3.repository.IUserRepository;
import com.example.du_an_tn_zingmp_3.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Iterable<Users> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public void save(Users users) {
        iUserRepository.save(users);
    }
}
