package com.NextLeap.Restaurant_Management_Platform_Project.Controllers;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.DTO.ReviewBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.FoodItemService;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.RestaurantService;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant-platform/v1/")
public class UserController {

    private final ReviewService reviewService;
    private final RestaurantService restaurantService;
    private final FoodItemService foodItemService;

    @PostMapping("restaurants/{restaurantId}/reviews")
    public ResponseEntity<?> postRestaurantReview(@PathVariable String restaurantId, @RequestBody ReviewBuilderDTO reviewBuilderDTO){
        try{
            return ResponseEntity.ok().body(reviewService.createReview(restaurantId, reviewBuilderDTO));
        }catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("restaurants/{restaurantId}/rating")
    public ResponseEntity<?> updateRestaurantRating(@PathVariable String restaurantId, @RequestParam Integer customerRating){
        try{
            return ResponseEntity.ok().body(restaurantService.updateRestaurantRating(restaurantId, customerRating));
        }catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("restaurants/menucategory/{foodItemId}/rating")
    public ResponseEntity<?> updateFoodItemRating(@PathVariable String foodItemId, @RequestParam Integer customerRating){
        try{
            return ResponseEntity.ok().body(foodItemService.updateFoodItemRating(foodItemId, customerRating));
        }catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
