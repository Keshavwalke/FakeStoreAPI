package com.example.fakestoreapi.controller;

import com.example.fakestoreapi.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController (CategoryService categoryService){
        this.categoryService=categoryService;
    }

    //Get all categories
    @GetMapping("/products/categories")
    public String getAllCategories(){
        return "Getting all Categories....";
    }

    //Get in a category
    @GetMapping("/products/categories/{categoryName}")
    public String getProductInSpecificCategory(@PathVariable("categoryName") String categoryName){
        return "Product in specific category  called-->" + categoryName;
    }


}
