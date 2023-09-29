package com.example.fakestoreapi.services;

import com.example.fakestoreapi.DTOs.ProductDTO;
import com.example.fakestoreapi.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(Long productId);
    Product addNewProduct( ProductDTO productDTO);

    // product  object has only those fields filled which needs to be updated, other things are null
    Product updateProduct(Long productId,Product product );
    Product deleteProduct( Long productId);
}
