package com.example.du_an_tn_zingmp_3.service.impl;

import com.example.du_an_tn_zingmp_3.model.UserPrinciple;
import com.example.du_an_tn_zingmp_3.model.User;
import com.example.du_an_tn_zingmp_3.repository.IUserRepository;
import com.example.du_an_tn_zingmp_3.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) {
        Users user = iUserRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        if (this.checkLogin(user)) {
            return UserPrinciple.build(user);
        }
        boolean enable = false;
        boolean accountNonExpired = false;
        boolean credentialsNonExpired = false;
        boolean accountNonLocked = false;
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), enable, accountNonExpired, credentialsNonExpired,
                accountNonLocked, null);
    }


    @Override
    public void save(Users user) {
        iUserRepository.save(user);
    }

    @Override
    public Iterable<Users> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Users findByUserName(String userName) {
        return iUserRepository.findByUserName(userName);
    }

    @Override
    public Users getCurrentUser() {
        Users user;
        String email;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }
        user = this.findByEmail(email);
        return user;
    }

    @Override
    public Optional<Users> findById(Long id) {
        return iUserRepository.findById(id);
    }

    @Override
    public UserDetails loadUserById(Long id) {
        Optional<Users> user = iUserRepository.findById(id);
        if (user.isEmpty()) {
            throw new NullPointerException();
        }
        return UserPrinciple.build(user.get());
    }

    @Override
    public boolean checkLogin(Users user) {
        Iterable<Users> users = this.findAll();
        boolean isCorrectUser = false;
        for (Users currentUser : users) {
            if (currentUser.getEmail().equals(user.getEmail()) && user.getPassword().equals(currentUser.getPassword()) && currentUser.isEnabled()) {
                isCorrectUser = true;
                break;
            }
        }
        return isCorrectUser;
    }

    @Override
    public boolean isRegister(Users user) {
        boolean isRegister = false;
        Iterable<Users> users = this.findAll();
        for (Users currentUser : users) {
            if (user.getEmail().equals(currentUser.getEmail())) {
                isRegister = true;
                break;
            }
        }
        return isRegister;
    }

    @Override
    public boolean isCorrectConfirmPassword(Users user) {
        return user.getPassword().equals(user.getConfirmPassword());
    }

    @Override
    public Users findByPassword(String pass) {
        return iUserRepository.findByPassword(pass);
    }
}
