package com.NextLeap.Restaurant_Management_Platform_Project.Repositories;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.RestaurantImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantImageRepository extends JpaRepository<RestaurantImage,String> {

    @Query("SELECT r.image FROM RestaurantImage r WHERE r.restaurant.id = :restaurantId")
    List<byte[]> findImageByRestaurantId(@Param("restaurantId") String restaurantId);
}

