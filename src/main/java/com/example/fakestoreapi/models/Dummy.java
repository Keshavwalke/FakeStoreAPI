package com.example.fakestoreapi.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Dummy extends BaseModel {
    private String name;
    private int ranged;
    private String dum;
}
