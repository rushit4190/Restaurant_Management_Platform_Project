package com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.DTO;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity.Address;
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
public class RestaurantOverviewDTO {
    private String Id;
    private String name;
    private String description;
    private byte[] poster;
    private Double Rating;
    private Integer totalRating;
    private Integer averageCost;
    private String phoneNo;
    private Address restaurantAddress;
    @JsonIgnoreProperties(value = {"id", "description","poster","restaurants"})
    private Set<Cuisine> cuisines;
}
