package com.example.fakestoreapi.inheritanceExamples.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCMentor_Repository extends JpaRepository<Mentor, Long> {
    Mentor save (Mentor mentor);
    Mentor findMentorById(Long id);
}