package com.example.webbookstore.service;

import com.example.webbookstore.model.User;

public interface UserService {

    Boolean existsUserByName(String name);

    User save(User user);

    User findUserByName(String name);

    User saveCreateRelationship(User user);

    User findUserByEmail(String email);

    User findUserById(Integer id);

}
