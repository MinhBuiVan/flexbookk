package com.example.flexbookk.repository;

import com.example.flexbookk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByUsernameAndPassword(String username, String password);
}
