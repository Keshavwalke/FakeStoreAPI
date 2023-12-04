package com.example.fakestoreapi.inheritanceExamples.joinedTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_TA")
@PrimaryKeyJoinColumn(name="user_id")
public class TA extends User {
    private double avgRating;

}
