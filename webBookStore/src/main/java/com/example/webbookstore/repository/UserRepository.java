package com.example.webbookstore.repository;

import com.example.webbookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where email = ?1" , nativeQuery = true)
    User findByEmail(String email);

    User findByName(String name);

    Boolean existsByName(String name);
}
