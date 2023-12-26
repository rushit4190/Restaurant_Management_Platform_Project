package com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomizationCategoryBuilderDTO {
    private String name;
    private String foodItemId;
}
