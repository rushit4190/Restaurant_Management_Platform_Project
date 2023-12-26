package com.NextLeap.Restaurant_Management_Platform_Project.Services;

import com.NextLeap.Restaurant_Management_Platform_Project.Exceptions.CustomException;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.DTO.RestaurantBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.DTO.RestaurantDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.DTO.RestaurantOverviewDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.MenuCategory.Entity.MenuCategory;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface RestaurantService {

    Restaurant createRestaurant(RestaurantBuilderDTO restaurantBuilderDTO);

    Restaurant updateRestaurant(String restaurantId, RestaurantBuilderDTO restaurantBuilderDTO);

    void deleteRestaurant(String restaurantId);

    Restaurant uploadRestaurantPoster(MultipartFile posterFile, String restaurantId) throws IOException;

    Restaurant updateRestaurantRating(String restaurantId, Integer customerRating);
    RestaurantOverviewDTO fetchRestaurantById(String restaurantId);

    RestaurantOverviewDTO fetchRestaurantByName(String restaurantName);

    List<MenuCategory> fetchRestaurantMenuById(String restaurantId);

    List<RestaurantDTO> fetchRestaurantDTOs(Integer pageNo, Integer pageSize);

    List<RestaurantDTO> fetchTopRestaurantDTOs(Integer pageNo, Integer pageSize);

    List<RestaurantDTO> fetchRestaurantDTOsWithFilters(
            String cuisines, Double ratingThreshold,
            Integer averageCostMin, Integer averageCostMax, String sortBy,
            String sortOrder, Integer pageNo, Integer pageSize) throws CustomException;

    List<RestaurantDTO> fetchRestaurantDTOsByCuisines(String cuisines, Integer pageNo, Integer pageSize) throws CustomException;


    List<RestaurantDTO> fetchRestaurantDTOsBySearchTermLimit10(String searchTerm);

}
