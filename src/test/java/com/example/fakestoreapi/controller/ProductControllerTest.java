package com.example.fakestoreapi.controller;

import com.example.fakestoreapi.models.Product;
import com.example.fakestoreapi.services.ProductService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import  static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Disabled
class ProductControllerTest {

    @MockBean   //spring will not create real object it'll create proxy object of product service here
    private ProductService productService;

    @Autowired
    private ProductController productController;

    //Test is nothing but method, by default test pass
    @Test
    void doSomething(){
        System.out.println("Printing something random");

    }

//    @Test
//    void getAllProductShouldReturnEmptyListWhenNoProduct(){
//        List<Product>  p=new ArrayList<>();
//        Product p1=new Product();
//        p1.setPrice(109.95);
//        p.add(p1);
//        when(productService.getAllProducts()).thenReturn(p);
//
//        List<Product> products =productController.getAllProducts();
//        assert products.get(0).getPrice()==109.95;
//
//        assertEquals(109.95, products.get(0).getPrice());  //preffered
//        assertTrue(products.get(0).getPrice()==109.95);
//
//
//     //   ********* Assert Library **********
//        //1. Pick the data you want to validate
//        //2. call the different validations you want to do
//        //In production it is advisable to use Assertj Library
//        assertThat(products.get(0).getPrice()).isEqualTo(109.95).
//                isGreaterThan(100).
//                isLessThan(200).isPositive();
//
//        System.out.println("getAllProducts returned emptylist when no product passed method passed...");
//                //always hardcode the expected values
//    }


}