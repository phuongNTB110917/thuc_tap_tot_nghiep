package com.example.webbookstore.service.impl;

import com.example.webbookstore.model.Role;
import com.example.webbookstore.model.User;
import com.example.webbookstore.repository.UserRepository;
import com.example.webbookstore.service.RoleService;
import com.example.webbookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Boolean existsByName(String name){
        return userRepository.existsByName(name);
    };

    @Override
    public User saveCreateRelationship(User user) {
        Role role = roleService.findByName("ROLE_USER");
        if(role != null) {
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
        }

        User user1 = userRepository.save(user);
//        Cart cart = new Cart();
//        cart.setUser(user1);
//        cartService.save(cart);
        return user1;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
