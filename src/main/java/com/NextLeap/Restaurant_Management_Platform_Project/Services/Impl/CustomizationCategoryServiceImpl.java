package com.NextLeap.Restaurant_Management_Platform_Project.Services.Impl;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.DTO.CustomizationCategoryBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.Entity.CustomizationCategory;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.Entity.FoodItem;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.CustomizationCategoryRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.FoodItemRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.CustomizationCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomizationCategoryServiceImpl implements CustomizationCategoryService {

    private final CustomizationCategoryRepository customizationCategoryRepository;
    private final FoodItemRepository foodItemRepository;

    @Override
    public CustomizationCategory createCustomizationCategory(CustomizationCategoryBuilderDTO customizationCategoryBuilderDTO) {
        FoodItem foodItemToEdit = foodItemRepository.findById(customizationCategoryBuilderDTO.getFoodItemId())
                                  .orElseThrow(() -> new NoSuchElementException("Food Item doesn't exist for given Id"));

        CustomizationCategory customizationCategoryToCreate = CustomizationCategory.builder()
                                                              .name(customizationCategoryBuilderDTO.getName())
                                                              .foodItem(foodItemToEdit)
                                                              .build();
        return customizationCategoryRepository.save(customizationCategoryToCreate);
    }
}
