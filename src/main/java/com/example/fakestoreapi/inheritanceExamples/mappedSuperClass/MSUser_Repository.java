package com.example.fakestoreapi.inheritanceExamples.mappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MSUser_Repository extends JpaRepository<User ,Long> {
    User save(User user);
 //   User findUserById (Long id);
}