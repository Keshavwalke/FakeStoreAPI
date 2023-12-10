package com.example.fakestoreapi.inheritanceExamples.singleTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface STMentor_Repository extends JpaRepository<Mentor, Long> {
    Mentor save (Mentor mentor);
    Mentor findMentorById(Long id);
}