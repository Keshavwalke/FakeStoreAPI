package com.example.fakestoreapi.inheritanceExamples.mappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Mentor_Repository extends JpaRepository<Mentor, Long> {
    Mentor save (Mentor mentor);
    Mentor findMentorById(Long id);
}
