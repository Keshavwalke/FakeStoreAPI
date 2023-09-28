package com.example.fakestoreapi.controller;

import com.example.fakestoreapi.DTOs.ProductDTO;
import com.example.fakestoreapi.services.ProductService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    //created ref of ProductService interface, code to interface principle
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    //Get All Products
    @GetMapping("/products")
    public String getAllProducts(){
        return "Getting all Products>>>>";
    }

    //Get a single product
    @GetMapping("/products/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId){
        return "Getting single Product...."+ productId;
    }

    //Add a new Product
    @PostMapping("/products")
    public String addNewProduct(@RequestBody  ProductDTO productDTO){
        return "Adding new Product" + productDTO;
    }

    //Update a new Product
    @PutMapping("/products/{productId}")
    public String updateProduct(@PathVariable ("productId") Long productId){
        return "Updating product" + productId;
    }

    //Delete a product
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "Deleting product with id " +productId ;
    }


}
