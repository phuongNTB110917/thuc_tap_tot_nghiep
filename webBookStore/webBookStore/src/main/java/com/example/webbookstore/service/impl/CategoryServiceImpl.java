package com.example.webbookstore.service.impl;

import com.example.webbookstore.model.Category;
import com.example.webbookstore.repository.CategoryRepository;
import com.example.webbookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
