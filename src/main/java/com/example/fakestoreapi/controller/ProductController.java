package com.example.fakestoreapi.controller;

import com.example.fakestoreapi.DTOs.ProductDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    //Method for getting all products
    @GetMapping("/products")
    public String getAllProducts(){
        return "Getting all Products>>>>";
    }

    //Method for getting single product
    @GetMapping("/products/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId){
        return "Getting single Product...."+ productId;
    }

    //Method for Adding new Product
    @PostMapping("/products")
    public String addNewProduct(@RequestBody  ProductDTO productDTO){
        return "Adding new Product" + productDTO;
    }

    //Method for updating product
    @PutMapping("/products/{productId}")
    public String updateProduct(@PathVariable ("productId") Long productId){
        return "Updating product" + productId;
    }

    //Method for deleting product
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "Deleting product with id " +productId ;
    }


}
