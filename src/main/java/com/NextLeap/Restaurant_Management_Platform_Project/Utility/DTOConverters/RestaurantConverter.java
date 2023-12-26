package com.NextLeap.Restaurant_Management_Platform_Project.Utility.DTOConverters;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.DTO.RestaurantDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.DTO.RestaurantOverviewDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantConverter {

    public RestaurantDTO convertToRestaurantDTO(Restaurant restaurant){
        return RestaurantDTO.builder()
                .Id(restaurant.getId())
                .name(restaurant.getName())
                .poster(restaurant.getPoster())
                .Rating(restaurant.getRating())
                .averageCost(restaurant.getAverageCost())
                .area(restaurant.getRestaurantAddress().getArea())
                .cuisines(restaurant.getCuisines())
                .build();
    }

    public List<RestaurantDTO> convertToRestaurantDTOList(List<Restaurant> restaurantList){
        List<RestaurantDTO> result = new ArrayList<>();

        for(Restaurant r : restaurantList){
            result.add(convertToRestaurantDTO(r));
        }
        return  result;
    }

    public RestaurantOverviewDTO convertToRestaurantOverviewDTO(Restaurant restaurant){
        return RestaurantOverviewDTO.builder()
                .Id(restaurant.getId())
                .name(restaurant.getName())
                .description(restaurant.getDescription())
                .poster(restaurant.getPoster())
                .Rating(restaurant.getRating())
                .totalRating(restaurant.getTotalRating())
                .phoneNo(restaurant.getPhoneNo())
                .restaurantAddress(restaurant.getRestaurantAddress())
                .cuisines(restaurant.getCuisines())
                .build();
    }

    public List<RestaurantOverviewDTO> convertToRestaurantOverviewDTOList(List<Restaurant> restaurantList){
        List<RestaurantOverviewDTO> result = new ArrayList<>();

        for(Restaurant r : restaurantList){
            result.add(convertToRestaurantOverviewDTO(r));
        }
        return result;
    }
}
