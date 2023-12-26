package com.NextLeap.Restaurant_Management_Platform_Project.Services;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.RestaurantImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface RestaurantImageService {

    RestaurantImage uploadRestaurantImage(String restaurantId, MultipartFile imageFile) throws IOException;

    List<String> fetchRestaurantImages(String restaurantId);
}
