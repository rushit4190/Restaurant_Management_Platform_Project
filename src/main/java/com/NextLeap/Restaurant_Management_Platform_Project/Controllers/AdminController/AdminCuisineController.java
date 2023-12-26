package com.NextLeap.Restaurant_Management_Platform_Project.Controllers.AdminController;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.DTO.CuisineBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.Entity.Cuisine;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.CuisineService;
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
@RequestMapping("/restaurant-platform/v1/admin/cuisine")
public class AdminCuisineController {
    final private CuisineService cuisineService;

    @PostMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> createCuisine(@RequestBody CuisineBuilderDTO cuisineBuilderDTO){
        return ResponseEntity.ok().body(cuisineService.addCuisine(cuisineBuilderDTO));
    }

    @PostMapping("/poster")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> uploadCuisinePosterData(@RequestParam("poster") MultipartFile posterFile,@RequestParam String cuisineName){
        try{
            Cuisine cuisineToEdit = cuisineService.uploadCuisinePoster(posterFile, cuisineName);
            return ResponseEntity.ok().body(cuisineToEdit);
        } catch (IOException | NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
