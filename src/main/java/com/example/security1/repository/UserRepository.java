package com.example.security1.repository;

import com.example.security1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    // JPA Query Methods
    // findBy (규칙) -> Username (문법)
    // select * from user where username = 1?
    public User findByUsername(String username);

}
