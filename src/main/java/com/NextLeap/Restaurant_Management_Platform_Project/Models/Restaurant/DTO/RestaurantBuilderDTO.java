package com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.DTO;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantBuilderDTO {
    private String name;
    private String description;
    private Integer averageCost;
    private String phoneNo;
    private Double rating;
    private Integer totalRating;
    private Address restaurantAddress;

}
