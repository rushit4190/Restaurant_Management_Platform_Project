package com.NextLeap.Restaurant_Management_Platform_Project.Controllers.AdminController;


import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.DTO.RestaurantBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.RestaurantImage;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.CuisineService;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.RestaurantImageService;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.RestaurantService;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant-platform/v1/admin/restaurant")
public class AdminRestaurantController {

    private final RestaurantService restaurantService;
    private final CuisineService  cuisineService;
    private final ReviewService reviewService;
    private final RestaurantImageService restaurantImageService;

    @PostMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> setupRestaurant(@RequestBody RestaurantBuilderDTO restaurantBuilderDTO){
        return ResponseEntity.ok().body(restaurantService.createRestaurant(restaurantBuilderDTO));
    }


    @PutMapping("/{restaurantId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> updateRestaurantData(@PathVariable String restaurantId, @RequestBody RestaurantBuilderDTO restaurantBuilderDTO){
        try{
            Restaurant restaurantToEdit = restaurantService.updateRestaurant(restaurantId, restaurantBuilderDTO);
            return ResponseEntity.ok().body(restaurantToEdit);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{restaurantId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteRestaurantData(@PathVariable String restaurantId){
        try{
            restaurantService.deleteRestaurant(restaurantId);
            return ResponseEntity.ok().body("Restaurant deleted successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/image")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> uploadRestaurantImage( @RequestParam("imageFile") MultipartFile imageFile, @RequestParam String restaurantId){
        try{
            RestaurantImage restaurantImageToCreate = restaurantImageService.uploadRestaurantImage(restaurantId, imageFile);
            return ResponseEntity.ok().body(restaurantImageToCreate);
        } catch (IOException | NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/poster")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> uploadRestaurantPosterData(@RequestParam("poster") MultipartFile posterFile, @RequestParam String restaurantId){
        try{
            Restaurant restaurantToEdit = restaurantService.uploadRestaurantPoster(posterFile, restaurantId);
            return ResponseEntity.ok().body(restaurantToEdit);
        } catch (IOException | NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/cuisine")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> addCuisineToRestaurantData(@RequestParam String cuisineName, @RequestParam String restaurantId){
        try{
            Restaurant restaurantToEdit = cuisineService.addCuisineToRestaurant(cuisineName, restaurantId);
            return ResponseEntity.ok().body(restaurantToEdit);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteRestaurantReview( @PathVariable String reviewId){
        try{
            reviewService.deleteReview(reviewId);
            return ResponseEntity.ok().body("Review successfully deleted");
        }catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body("Review not deleted " + e.getMessage());
        }

    }


}
