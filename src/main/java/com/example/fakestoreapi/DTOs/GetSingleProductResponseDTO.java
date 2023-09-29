package com.example.fakestoreapi.DTOs;

import com.example.fakestoreapi.models.Category;
import com.example.fakestoreapi.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleProductResponseDTO {
   private Product product;
}
