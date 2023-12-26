package com.NextLeap.Restaurant_Management_Platform_Project.Services.Impl;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.DTO.CustomizationBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.Entity.Customization;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.Entity.CustomizationCategory;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.CustomizationCategoryRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.CustomizationRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.CustomizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomizationServiceImpl implements CustomizationService {

    private final CustomizationCategoryRepository customizationCategoryRepository;
    private final CustomizationRepository customizationRepository;

    @Override
    public Customization createCustomization(CustomizationBuilderDTO customizationBuilderDTO) {
        CustomizationCategory customizationCategoryToEdit = customizationCategoryRepository.findById(customizationBuilderDTO.getCustomizationCategoryId())
                                                          .orElseThrow(() -> new NoSuchElementException("Customization Category doesn't exist for given Id"));

        Customization customizationToCreate = Customization.builder()
                                              .name(customizationBuilderDTO.getName())
                                              .priceModifier(customizationBuilderDTO.getPriceModifier())
                                              .available(customizationBuilderDTO.isAvailable())
                                              .customizationCategory(customizationCategoryToEdit)
                                              .build();

        return customizationRepository.save(customizationToCreate);
    }
}
