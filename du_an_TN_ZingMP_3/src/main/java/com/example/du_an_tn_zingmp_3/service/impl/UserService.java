package com.example.du_an_tn_zingmp_3.service.impl;

import com.example.du_an_tn_zingmp_3.model.UserPrinciple;
import com.example.du_an_tn_zingmp_3.model.User;
import com.example.du_an_tn_zingmp_3.repository.IUserRepository;
import com.example.du_an_tn_zingmp_3.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        if (this.checkLogin(user)) {
            return UserPrinciple.build(user);
        }
        boolean enable = false;
        boolean accountNonExpired = false;
        boolean credentialsNonExpired = false;
        boolean accountNonLocked = false;
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), enable, accountNonExpired, credentialsNonExpired,
                accountNonLocked, null);
    }


    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public User getCurrentUser() {
        User user;
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        user = this.findByUsername(userName);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NullPointerException();
        }
        return UserPrinciple.build(user.get());
    }

    @Override
    public boolean checkLogin(User user) {
        Iterable<User> users = this.findAll();
        boolean isCorrectUser = false;
        for (User currentUser : users) {
            if (currentUser.getUserName().equals(user.getUserName()) && user.getPassword().equals(currentUser.getPassword()) && currentUser.isEnabled()) {
                isCorrectUser = true;
                break;
            }
        }
        return isCorrectUser;
    }

    @Override
    public boolean isRegister(User user) {
        boolean isRegister = false;
        Iterable<User> users = this.findAll();
        for (User currentUser : users) {
            if (user.getUserName().equals(currentUser.getUserName())) {
                isRegister = true;
                break;
            }
        }
        return isRegister;
    }

    @Override
    public boolean isCorrectConfirmPassword(User user) {
        return user.getPassword().equals(user.getConfirmedPassword());
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
