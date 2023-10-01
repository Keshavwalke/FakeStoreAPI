package com.example.fakestoreapi.services;

import com.example.fakestoreapi.models.Category;

import java.util.List;

public interface CategoryService {
    List<String> getAllCategories();
    String getProductsInCategory(Long categoryId);
}
