package com.example.fakestoreapi.inheritanceExamples.singleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_Mentor")
@DiscriminatorValue("2")
public class Mentor extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int noSessions;
    private  int noOfMentees;

}
