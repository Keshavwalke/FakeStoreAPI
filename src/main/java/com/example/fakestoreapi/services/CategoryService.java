package com.example.fakestoreapi.services;

public interface CategoryService {
    String getAllCategories();
    String getProductsInCategory(Long categoryId);
}
