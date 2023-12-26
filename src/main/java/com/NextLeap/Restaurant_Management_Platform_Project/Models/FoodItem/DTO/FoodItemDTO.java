package com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {
    private String Id;
    private String name;
    private byte[] poster;
    private Double price;
    private String restaurantId;
    private String restaurantName;
    private Double restaurantRating;
    private String restaurantArea;
}
