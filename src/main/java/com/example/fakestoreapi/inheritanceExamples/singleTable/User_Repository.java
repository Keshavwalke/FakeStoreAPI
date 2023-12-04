package com.example.fakestoreapi.inheritanceExamples.singleTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface User_Repository extends JpaRepository<User ,Long> {
    User save(User user);
    User findUserById (Long id);
}
