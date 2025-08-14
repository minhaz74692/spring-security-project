package com.mie.secureapp.repository;

import com.mie.secureapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String userName);
}
