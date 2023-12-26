package com.NextLeap.Restaurant_Management_Platform_Project.Models.MenuCategory.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuCategoryBuilderDTO {
    private String name;
    private String restaurantId;
}
