package com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.DTO;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.Entity.Cuisine;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    private String Id;
    private String name;
    private byte[] poster;
    private Double Rating;
    private Integer averageCost;
    private String area;
    @JsonIgnoreProperties(value = {"id", "description","poster","restaurants"})
    private Set<Cuisine> cuisines;

}
