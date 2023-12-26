package com.NextLeap.Restaurant_Management_Platform_Project.Services;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.DTO.CuisineBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.DTO.CuisineDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.Entity.Cuisine;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CuisineService {

    Cuisine addCuisine(CuisineBuilderDTO cuisineBuilderDTO);

    Cuisine uploadCuisinePoster(MultipartFile posterFile, String cuisineName) throws IOException;

    Restaurant addCuisineToRestaurant(String cuisineName, String restaurantId);

    Restaurant removeCuisineFromTheRestaurant(String cuisineName, String restaurantId);

    Cuisine fetchCuisineById(String cuisineId);

    Cuisine fetchCuisineByName(String cuisineName);

    List<CuisineDTO> fetchCuisineDTOs(Integer pageNo, Integer pageSize);
}
