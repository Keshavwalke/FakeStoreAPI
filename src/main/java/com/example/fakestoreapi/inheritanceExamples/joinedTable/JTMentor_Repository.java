package com.example.fakestoreapi.inheritanceExamples.joinedTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTMentor_Repository extends JpaRepository<Mentor, Long> {
    Mentor save(Mentor mentor);
    Mentor findMentorById(Long id);
}
