package com.example.du_an_tn_zingmp_3.service.impl;

import com.example.du_an_tn_zingmp_3.model.Roles;
import com.example.du_an_tn_zingmp_3.repository.IRoleRepository;
import com.example.du_an_tn_zingmp_3.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
  @Autowired
    private IRoleRepository iRoleRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Iterable<Roles> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Roles> findById(Long id) {
        return iRoleRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        iRoleRepository.deleteById(id);
    }

    @Override
    public void save(Roles role) {
        roleRepository.save(role);
    }

    @Override
    public Roles findByName(String name) {
        return roleRepository.findByName(name);
    }

}
