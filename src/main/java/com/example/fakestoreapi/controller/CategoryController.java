package com.example.fakestoreapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    //Method for getting all categories
    @GetMapping("/products/categories")
    public String getAllCategories(){
        return "Getting all Categories....";
    }

    //Method for getting product in specific category
    @GetMapping("/products/categories/{categoryName}")
    public String getProductInSpecificCategory(@PathVariable("categoryName") String categoryName){
        return "Product in specific category  called-->" + categoryName;
    }


}
