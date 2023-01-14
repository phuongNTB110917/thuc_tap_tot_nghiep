package com.example.webbookstore.service.impl;

import com.example.webbookstore.model.Role;
import com.example.webbookstore.repository.RoleRepository;
import com.example.webbookstore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
