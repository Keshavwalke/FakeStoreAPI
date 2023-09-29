package com.example.fakestoreapi.controller;

import com.example.fakestoreapi.DTOs.ProductDTO;
import com.example.fakestoreapi.models.Product;
import com.example.fakestoreapi.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    //created ref of ProductService interface, code to interface principle
    //Our controller should not take model, they should take DTO's
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    //Get All Products
    @GetMapping("/products")
    public List<Product> getAllProducts(){
       return productService.getAllProducts();
    }

    //Get a single product
//    @GetMapping("/products/{productId}")
//    public GetSingleProductResponseDTO getSingleProduct(@PathVariable("productId") Long productId){
//        GetSingleProductResponseDTO responseDTO=new GetSingleProductResponseDTO();
//        responseDTO.setProduct(productService.getSingleProduct(productId));
//        return responseDTO;
//    }


    //Another way get single product (added headers, HTTP status)
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("auth-token", "Access is granted bro");
        ResponseEntity<Product> response=new ResponseEntity<>(
                productService.getSingleProduct(productId),
                headers, HttpStatus.OK);
        return response;
    }

    //Add a new Product
    @PostMapping("/products")
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDTO productDTO){
        Product newPrduct=productService.addNewProduct(productDTO);
        ResponseEntity<Product> response= new ResponseEntity<>(
                newPrduct,HttpStatus.OK);
        return response;
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
