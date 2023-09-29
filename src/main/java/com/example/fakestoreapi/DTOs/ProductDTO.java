package com.example.fakestoreapi.DTOs;


import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    @Nullable
    private Long id;
    private String title;
    private double price;
    private String description;
    private  String image;
    private String category;
}
