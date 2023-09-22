package com.example.fakestoreapi.DTOs;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private String title;
    private String price;
    private String description;
    private  String image;
    private String category;
}
