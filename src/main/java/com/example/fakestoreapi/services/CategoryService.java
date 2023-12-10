package com.example.fakestoreapi.services;

import com.example.fakestoreapi.models.Category;
import com.example.fakestoreapi.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    List<String> getAllCategories();
    List<Product> getProductsInCategory(String title);
}
