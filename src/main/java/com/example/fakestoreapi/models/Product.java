package com.example.fakestoreapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private String title;
    private long price;
    private String category;
    private String description;
    private String imageURL;

}
