package com.example.fakestoreapi.inheritanceExamples.joinedTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTUser_Repository extends JpaRepository<User ,Long> {
    User save(User user);
    User findUserById (Long id);

}
