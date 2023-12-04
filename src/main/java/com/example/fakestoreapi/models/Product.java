package com.example.fakestoreapi.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;

    //This means many Products mapped to one category
    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private Category category;
    private String image;
}
