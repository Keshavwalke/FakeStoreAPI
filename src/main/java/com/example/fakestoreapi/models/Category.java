package com.example.fakestoreapi.models;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import  java.util.List;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseModel {
    private String title;
    private String description;

    //This simply means one category mapped many product
    @OneToMany(mappedBy ="category")
    private List<Product> product;

}
