package com.example.webbookstore.service;

import com.example.webbookstore.model.User;

public interface UserService {

    Boolean existsByName(String name);

    User save(User user);

    User findByName(String name);

    User saveCreateRelationship(User user);

    User findByEmail(String email);

    User findById(Integer id);

}
