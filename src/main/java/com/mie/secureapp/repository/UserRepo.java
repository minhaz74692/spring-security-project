package com.mie.secureapp.repository;

import com.mie.secureapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    // This interface will automatically inherit methods for CRUD operations
    // and can be extended with custom query methods if needed.

    // Example of a custom query method:
    // Users findByUsername(String username);
}
