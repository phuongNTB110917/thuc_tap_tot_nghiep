package com.example.webbookstore.repository;


import com.example.webbookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Override
    List<Category> findAll();
}
