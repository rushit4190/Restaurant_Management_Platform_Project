package com.NextLeap.Restaurant_Management_Platform_Project.Services;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.DTO.CustomizationBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.Entity.Customization;

public interface CustomizationService {

    Customization createCustomization(CustomizationBuilderDTO customizationBuilderDTO);

}
