package com.example.fakestoreapi.services;

import com.example.fakestoreapi.DTOs.ProductDTO;
import com.example.fakestoreapi.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getSingleProduct(Long productId);
    Product addNewProduct( ProductDTO productDTO);

    // product  object has only those fields filled which needs to be updated, other things are null
    Product updateProduct(Long productId,Product product );
    Product replaceProduct(Long productId,Product product );
    Product deleteProduct( Long productId);
}
