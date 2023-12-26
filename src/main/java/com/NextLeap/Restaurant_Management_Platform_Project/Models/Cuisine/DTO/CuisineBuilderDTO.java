package com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuisineBuilderDTO {
    private String name;
    private String description;

}
