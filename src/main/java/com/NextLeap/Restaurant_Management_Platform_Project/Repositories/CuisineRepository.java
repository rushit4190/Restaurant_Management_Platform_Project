package com.NextLeap.Restaurant_Management_Platform_Project.Repositories;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.Entity.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine,String> {
    Optional<Cuisine> findByNameIgnoreCase(String name);
}
