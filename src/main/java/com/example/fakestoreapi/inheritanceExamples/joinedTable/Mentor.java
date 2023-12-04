package com.example.fakestoreapi.inheritanceExamples.joinedTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_Mentor")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {
    private int noSessions;
    private  int noOfMentees;

}
