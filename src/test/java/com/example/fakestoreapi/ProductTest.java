package com.example.fakestoreapi;

import com.example.fakestoreapi.models.Category;
import org.junit.jupiter.api.Test;

public class ProductTest {


//    Category category=new Category();
//    category.settitle("Electronics");
//    category.setdescription("new Electronics");

    @Test
    void getProductsFromCategory(){
        Category category =categoryRepository.findById(2L);

    }
}
