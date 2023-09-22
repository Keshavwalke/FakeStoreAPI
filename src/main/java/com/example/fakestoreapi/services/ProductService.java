package com.example.fakestoreapi.services;

import com.example.fakestoreapi.DTOs.ProductDTO;
import org.springframework.web.bind.annotation.*;

public interface ProductService {
    String getAllProducts();
    String getSingleProduct(Long productId);
    String addNewProduct( ProductDTO productDTO);
    String updateProduct(Long productId);
    String deleteProduct( Long productId);
}
