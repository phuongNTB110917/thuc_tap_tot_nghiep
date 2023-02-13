package com.example.hue.repositories;


import com.example.hue.models.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Override
    List<Category> findAll();
}
