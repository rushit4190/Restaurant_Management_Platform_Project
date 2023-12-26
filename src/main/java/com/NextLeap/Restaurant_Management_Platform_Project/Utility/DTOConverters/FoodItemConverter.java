package com.NextLeap.Restaurant_Management_Platform_Project.Utility.DTOConverters;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.DTO.FoodItemDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.Entity.FoodItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodItemConverter {

    public FoodItemDTO convertToFoodItemDTO(FoodItem foodItem){
        return FoodItemDTO.builder()
                .Id(foodItem.getId())
                .name(foodItem.getName())
                .poster(foodItem.getPoster())
                .price(foodItem.getPrice())
                .restaurantId(foodItem.getMenuCategory().getRestaurant().getId())
                .restaurantName(foodItem.getMenuCategory().getRestaurant().getName())
                .restaurantRating(foodItem.getMenuCategory().getRestaurant().getRating())
                .restaurantArea(foodItem.getMenuCategory().getRestaurant().getRestaurantAddress().getArea())
                .build();
    }

    public List<FoodItemDTO> convertToFoodItemDTOList(List<FoodItem> foodItemList){
        List<FoodItemDTO> result = new ArrayList<>();

        for(FoodItem f : foodItemList){
            result.add(convertToFoodItemDTO(f));
        }
        return result;
    }
}
