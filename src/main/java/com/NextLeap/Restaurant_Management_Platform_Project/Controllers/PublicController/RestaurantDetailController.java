package com.NextLeap.Restaurant_Management_Platform_Project.Controllers.PublicController;

import com.NextLeap.Restaurant_Management_Platform_Project.Services.MenuCategoryService;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.RestaurantImageService;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.RestaurantService;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant-platform/v1/")
public class RestaurantDetailController {

    private final RestaurantService restaurantService;
    private final MenuCategoryService menuCategoryService;
    private final ReviewService reviewService;
    private final RestaurantImageService restaurantImageService;

    @GetMapping("restaurants/id/{restaurantId}")
    public ResponseEntity<?> getRestaurantById(@PathVariable String restaurantId){
        try{
            return ResponseEntity.ok().body(restaurantService.fetchRestaurantById(restaurantId));
        }catch (NoSuchElementException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("restaurants/name/{name}")
    public ResponseEntity<?> getRestaurantByName(@PathVariable String name){
        try{
            return ResponseEntity.ok().body(restaurantService.fetchRestaurantByName(name));
        }catch (NoSuchElementException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("restaurants/{restaurantId}/menu")
    public ResponseEntity<?> getRestaurantMenu(@PathVariable String restaurantId){
        try{
            return ResponseEntity.ok().body(restaurantService.fetchRestaurantMenuById(restaurantId));
        }catch (NoSuchElementException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("restaurants/menucategory/{menuCategoryId}")
    public ResponseEntity<?> getMenuDetails(@PathVariable String menuCategoryId){
        try{
            return ResponseEntity.ok().body(menuCategoryService.fetchMenuCategoryById(menuCategoryId));
        }catch (NoSuchElementException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("restaurants/{restaurantId}/reviews")
    public ResponseEntity<?> getRestaurantReviews(@PathVariable String restaurantId, @RequestParam(defaultValue = "0") Integer pageNo,
                                                  @RequestParam(defaultValue = "2") Integer pageSize){
        try{
            return ResponseEntity.ok().body(reviewService.fetchReviewsByRestaurantId(restaurantId, pageNo, pageSize));
        }catch (NoSuchElementException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("restaurants/{restaurantId}/image")
    public ResponseEntity<?> getRestaurantImageData(@PathVariable String restaurantId){
        try{
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(restaurantImageService.fetchRestaurantImages(restaurantId));
        }catch (NoSuchElementException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

}
