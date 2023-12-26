package com.NextLeap.Restaurant_Management_Platform_Project.Controllers.AdminController;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.DTO.CustomizationBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.DTO.CustomizationCategoryBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.Entity.FoodItem;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.DTO.FoodItemBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.MenuCategory.DTO.MenuCategoryBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.CustomizationCategoryService;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.CustomizationService;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.FoodItemService;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.MenuCategoryService;
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
public class AdminMenuFoodItemController {

    private final MenuCategoryService menuCategoryService;
    private final FoodItemService foodItemService;
    private final CustomizationCategoryService customizationCategoryService;
    private final CustomizationService customizationService;

    @PostMapping("/menucategory")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> setupMenuCategory(@RequestBody MenuCategoryBuilderDTO menuCategoryBuilderDTO){
        return ResponseEntity.ok().body(menuCategoryService.createMenuCategory(menuCategoryBuilderDTO));
    }

    @PostMapping("/menucategory/fooditem")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> setupFoodItem(@RequestBody FoodItemBuilderDTO foodItemBuilderDTO){
        return ResponseEntity.ok().body(foodItemService.createFoodItem(foodItemBuilderDTO));
    }

    @PostMapping("/menucategory/fooditem/poster")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> uploadFoodItemPosterData(@RequestParam("poster") MultipartFile posterFile, @RequestParam String foodItemId){
        try{
            FoodItem foodItemToEdit = foodItemService.uploadFoodItemPoster(posterFile, foodItemId);
            return ResponseEntity.ok().body(foodItemToEdit);
        } catch (IOException | NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/menucategory/fooditem/customizationcategory")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> setupCustomizationCategory(@RequestBody CustomizationCategoryBuilderDTO customizationCategoryBuilderDTO){
        return ResponseEntity.ok().body(customizationCategoryService.createCustomizationCategory(customizationCategoryBuilderDTO));
    }

    @PostMapping("/menucategory/fooditem/customizationcategory/customization")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> setupCustomization(@RequestBody CustomizationBuilderDTO customizationBuilderDTO){
        return ResponseEntity.ok().body(customizationService.createCustomization(customizationBuilderDTO));
    }

    @PutMapping("/menucategory/fooditem/{foodItemId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> updateFoodItem(@PathVariable String foodItemId, @RequestBody FoodItemBuilderDTO foodItemBuilderDTO){
        try{
            return ResponseEntity.ok().body(foodItemService.updateFoodItem(foodItemId, foodItemBuilderDTO));
        }catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/menucategory/fooditem/{foodItemId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteFoodItem(@PathVariable String foodItemId){
        try{
            foodItemService.deleteFoodItem(foodItemId);
            return ResponseEntity.ok().body("Food Item deleted successfully");
        }catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
