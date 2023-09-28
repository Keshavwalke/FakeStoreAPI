package com.example.fakestoreapi.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryServiceImp implements CategoryService {

    @Override
    public String getAllCategories() {
        return null;
    }

    @Override
    public String getProductsInCategory(Long categoryId) {
        return null;
    }
}
