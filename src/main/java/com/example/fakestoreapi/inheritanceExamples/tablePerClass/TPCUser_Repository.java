package com.example.fakestoreapi.inheritanceExamples.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCUser_Repository extends JpaRepository<User ,Long> {
    User save(User user);
    User findUserById (Long id);
}