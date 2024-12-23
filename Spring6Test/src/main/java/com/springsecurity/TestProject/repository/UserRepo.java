package com.springsecurity.TestProject.repository;

import com.springsecurity.TestProject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
    public Users findByUsername(String username);
}
