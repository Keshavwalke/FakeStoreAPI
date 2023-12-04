package com.example.fakestoreapi.inheritanceExamples.mappedSuperClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_Instructor")
public class Instructor extends User {
    private String batchName;
}
