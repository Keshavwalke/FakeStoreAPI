package com.example.fakestoreapi.DTOs;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

@Getter
@Setter
@ToString
public class ProductDTO {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

}
