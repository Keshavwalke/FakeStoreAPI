package com.example.fakestoreapi.inheritanceExamples.mappedSuperClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_Mentor")
public class Mentor extends User {
    private int noSessions;
    private  int noOfMentees;

}
