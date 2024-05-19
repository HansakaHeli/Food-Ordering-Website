package com.heli.repository;

import com.heli.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
    // findByEmail -> Email is field name email form User class
}
