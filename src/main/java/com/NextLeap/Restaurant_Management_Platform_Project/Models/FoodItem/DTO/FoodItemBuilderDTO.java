package com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemBuilderDTO {
    private String name;
    private String description;
    private boolean veg;
    private Double price;
    private Double rating;
    private Integer totalRating;
    private boolean available;
    private String menuCategoryId;
}
