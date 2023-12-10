package com.example.fakestoreapi.inheritanceExamples.singleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_Instructor")
@DiscriminatorValue("1")
public class Instructor extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String batchName;
}
