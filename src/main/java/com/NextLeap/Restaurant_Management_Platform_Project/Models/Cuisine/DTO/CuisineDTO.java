package com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuisineDTO {
    private String Id;
    private String name;
    private byte[] poster;
}
