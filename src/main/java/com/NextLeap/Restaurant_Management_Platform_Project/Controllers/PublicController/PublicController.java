package com.NextLeap.Restaurant_Management_Platform_Project.Controllers.PublicController;

import com.NextLeap.Restaurant_Management_Platform_Project.Services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant-platform/v1/")
public class PublicController {

    private final RestaurantService restaurantService;
    @GetMapping("/")
    public ResponseEntity<?> checkConnection(){
        return ResponseEntity.ok().body("Connected to NextLeap restaurant management platform");
    }

    @GetMapping("restaurants/top")
    public ResponseEntity<?> getTop10RestaurantDTOs(@RequestParam(defaultValue = "0") Integer pageNo,
                                                    @RequestParam(defaultValue = "10") Integer pageSize){
        return ResponseEntity.ok().body(restaurantService.fetchTopRestaurantDTOs(pageNo, pageSize));
    }

}
