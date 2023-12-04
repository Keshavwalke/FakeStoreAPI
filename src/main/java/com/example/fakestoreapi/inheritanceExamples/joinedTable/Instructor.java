package com.example.fakestoreapi.inheritanceExamples.joinedTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_Instructor")
@PrimaryKeyJoinColumn(name="user_id")
public class Instructor extends User {
    private String batchName;
}
