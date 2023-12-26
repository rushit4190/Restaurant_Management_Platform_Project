package com.NextLeap.Restaurant_Management_Platform_Project.Services.Impl;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.MenuCategory.DTO.MenuCategoryBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.MenuCategory.Entity.MenuCategory;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.MenuCategoryRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.RestaurantRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.MenuCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MenuCategoryServiceImpl implements MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;
    private final RestaurantRepository restaurantRepository;
    @Override
    public MenuCategory createMenuCategory(MenuCategoryBuilderDTO menuCategoryBuilderDTO) {
        Restaurant restaurantToEdit = restaurantRepository.findById(menuCategoryBuilderDTO.getRestaurantId()).orElseThrow(() -> new NoSuchElementException("Restaurant doesn't exist for given Id"));
        MenuCategory menuCategoryToCreate = MenuCategory.builder()
                                            .name(menuCategoryBuilderDTO.getName())
                                            .restaurant(restaurantToEdit)
                                            .build();
        return menuCategoryRepository.save(menuCategoryToCreate);
    }

    @Override
    public MenuCategory fetchMenuCategoryById(String menuCategoryId) {

        return menuCategoryRepository.findById(menuCategoryId)
                .orElseThrow(() -> new NoSuchElementException("Menu category doesn't exist for given Id"));
    }
}
