package com.NextLeap.Restaurant_Management_Platform_Project.Services;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.DTO.FoodItemBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.DTO.FoodItemDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.Entity.FoodItem;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface FoodItemService {
    FoodItem createFoodItem(FoodItemBuilderDTO foodItemBuilderDTO);
    FoodItem uploadFoodItemPoster(MultipartFile posterFile, String foodItemId) throws IOException;

    FoodItem updateFoodItem(String foodItemId, FoodItemBuilderDTO foodItemBuilderDTO);
    void deleteFoodItem(String foodItemId);

    FoodItem updateFoodItemRating(String foodItemId, Integer customerRating);

    List<FoodItemDTO> fetchFoodItemsDTOsBySearchTermLimit15(String searchTerm);

}
