package com.example.fakestoreapi.controller;

import com.example.fakestoreapi.models.Category;
import com.example.fakestoreapi.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }


    //Get all categories
    @GetMapping("/products/categories")
    public List<String> getAllCategories(){
        return categoryService.getAllCategories();
    }

    //Get in a category
    @GetMapping("/products/categories/{categoryName}")
    public String getProductInSpecificCategory(@PathVariable("categoryName") String categoryName){
        return "Product in specific category  called-->" + categoryName;
    }


}
