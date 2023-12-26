package com.NextLeap.Restaurant_Management_Platform_Project.Repositories;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.Entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,String> {

    @Query(value = "SELECT DISTINCT f.* FROM food_items f WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) LIMIT 15", nativeQuery = true)
    List<FoodItem> findDistinctFoodItemsBySearchTermLimit15(@Param("searchTerm") String searchTerm);
}
