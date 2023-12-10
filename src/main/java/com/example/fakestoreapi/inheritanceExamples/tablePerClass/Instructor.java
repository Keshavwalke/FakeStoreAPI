package com.example.fakestoreapi.inheritanceExamples.tablePerClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_Instructor")
public class Instructor extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String batchName;
}
