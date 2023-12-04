package com.example.fakestoreapi.inheritanceExamples.mappedSuperClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_TA")
public class TA extends User {
    private double avgRating;

}
