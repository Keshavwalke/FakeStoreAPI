package com.example.fakestoreapi.inheritanceExamples.singleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_TA")
@DiscriminatorValue("3")
public class TA extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double avgRating;

}
