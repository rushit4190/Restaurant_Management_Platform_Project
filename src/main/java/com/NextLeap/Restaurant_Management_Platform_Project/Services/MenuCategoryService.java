package com.NextLeap.Restaurant_Management_Platform_Project.Services;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.MenuCategory.DTO.MenuCategoryBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.MenuCategory.Entity.MenuCategory;

public interface MenuCategoryService {

    MenuCategory createMenuCategory(MenuCategoryBuilderDTO menuCategoryBuilderDTO);

    MenuCategory fetchMenuCategoryById(String menuCategoryId);
}
