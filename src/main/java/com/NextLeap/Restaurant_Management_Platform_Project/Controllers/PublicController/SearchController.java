package com.NextLeap.Restaurant_Management_Platform_Project.Controllers.PublicController;

import com.NextLeap.Restaurant_Management_Platform_Project.Services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant-platform/v1/")
public class SearchController {

    private final RestaurantService restaurantService;
    private final FoodItemService foodItemService;

    @GetMapping("search/fooditems")
    public ResponseEntity<?> searchFoodItemsBySearchTerm(@RequestParam String searchTerm){

        return ResponseEntity.ok().body(foodItemService.fetchFoodItemsDTOsBySearchTermLimit15(searchTerm));
    }
    @GetMapping("search/restaurants")
    public ResponseEntity<?> searchRestaurantsBySearchTerm(@RequestParam String searchTerm){
        return ResponseEntity.ok().body(restaurantService.fetchRestaurantDTOsBySearchTermLimit10(searchTerm));
    }
}
