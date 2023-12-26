package com.NextLeap.Restaurant_Management_Platform_Project.Controllers.PublicController;

import com.NextLeap.Restaurant_Management_Platform_Project.Exceptions.CustomException;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant-platform/v1/")
public class LandingPageController {

    private final RestaurantService restaurantService;
    private final CuisineService cuisineService;

    @GetMapping("cuisines")
    public ResponseEntity<?> getCuisineDTOs(@RequestParam(defaultValue = "0") Integer pageNo,
                                            @RequestParam(defaultValue = "5") Integer pageSize){
        return ResponseEntity.ok().body(cuisineService.fetchCuisineDTOs(pageNo, pageSize));
    }

    @GetMapping("restaurants")
    public ResponseEntity<?> getRestaurantDTOs(@RequestParam(defaultValue = "0") Integer pageNo,
                                               @RequestParam(defaultValue = "4") Integer pageSize){
        return ResponseEntity.ok().body(restaurantService.fetchRestaurantDTOs(pageNo, pageSize));
    }
    @GetMapping("restaurants/filter")
    public ResponseEntity<?> getRestaurantDTOsWithFilters(
            @RequestParam(defaultValue = "") String cuisines,
            @RequestParam(defaultValue = "0.0") Double ratingThreshold,
            @RequestParam(defaultValue = "0") Integer averageCostMin,
            @RequestParam(defaultValue = "100000") Integer averageCostMax,
            @RequestParam(defaultValue = "rating") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortOrder,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize){

        try {
            return ResponseEntity.ok().body(
                    restaurantService.fetchRestaurantDTOsWithFilters(
                            cuisines,ratingThreshold,averageCostMin,averageCostMax,sortBy,sortOrder,pageNo,pageSize));
        } catch (CustomException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @GetMapping("restaurants/cuisine/filter")
    public ResponseEntity<?> getRestaurantDTOsByCuisineFilters(
            @RequestParam(defaultValue = "") String cuisines,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize) {

        try {
            return ResponseEntity.ok().body(restaurantService.fetchRestaurantDTOsByCuisines(cuisines,pageNo,pageSize));
        } catch (CustomException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }


}
