package com.NextLeap.Restaurant_Management_Platform_Project.Repositories;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
