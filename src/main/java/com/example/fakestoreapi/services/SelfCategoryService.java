package com.example.fakestoreapi.services;
import com.example.fakestoreapi.models.Product;
import com.example.fakestoreapi.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfCategoryService implements CategoryService{
    CategoryRepository categoryRepository;
    public SelfCategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    @Override
    public List<String> getAllCategories() {
        return categoryRepository.findAllTitlesBy();
    }

    @Override
    public List<Product> getProductsInCategory(String title) {
        return categoryRepository.getProductsInCategory(title);
    }
}
