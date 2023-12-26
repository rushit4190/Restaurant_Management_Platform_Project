package com.NextLeap.Restaurant_Management_Platform_Project.Services.Impl;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.DTO.FoodItemBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.DTO.FoodItemDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.Entity.FoodItem;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.MenuCategory.Entity.MenuCategory;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.FoodItemRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.MenuCategoryRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.FoodItemService;
import com.NextLeap.Restaurant_Management_Platform_Project.Utility.DTOConverters.FoodItemConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {

    private final MenuCategoryRepository menuCategoryRepository;
    private final FoodItemRepository foodItemRepository;
    private final FoodItemConverter foodItemConverter;
    @Override
    public FoodItem createFoodItem(FoodItemBuilderDTO foodItemBuilderDTO) {
        MenuCategory menuCategoryToEdit = menuCategoryRepository.findById(foodItemBuilderDTO.getMenuCategoryId())
                                          .orElseThrow(() -> new NoSuchElementException("Menu Category doesn't exist for given Id"));
//        System.out.println(foodItemBuilderDTO.isVeg());

        FoodItem foodItemToCreate = FoodItem.builder()
                                    .name(foodItemBuilderDTO.getName())
                                    .description(foodItemBuilderDTO.getDescription())
                                    .veg(foodItemBuilderDTO.isVeg())
                                    .price(foodItemBuilderDTO.getPrice())
                                    .rating(foodItemBuilderDTO.getRating())
                                    .totalRatings(foodItemBuilderDTO.getTotalRating())
                                    .available(foodItemBuilderDTO.isAvailable())
                                    .menuCategory(menuCategoryToEdit)
                                    .build();

        return foodItemRepository.save(foodItemToCreate);
    }

    @Override
    public FoodItem uploadFoodItemPoster(MultipartFile posterFile, String foodItemId) throws IOException {
        FoodItem foodItemToEdit = foodItemRepository.findById(foodItemId)
                                  .orElseThrow(() -> new NoSuchElementException("Food Item doesn't exist for given Id"));

        foodItemToEdit.setPoster(posterFile.getBytes());

        return foodItemRepository.save(foodItemToEdit);
    }

    @Override
    public FoodItem updateFoodItem(String foodItemId, FoodItemBuilderDTO foodItemBuilderDTO) {
        //Ensure boolean fields of veg and available are not null and kept as it is in JSON payload when they are not
        // required to be updated.
        FoodItem foodItemToEdit = foodItemRepository.findById(foodItemId)
                .orElseThrow(() -> new NoSuchElementException("Food Item doesn't exist for given Id"));

        if(!foodItemBuilderDTO.getName().isEmpty()){
            foodItemToEdit.setName(foodItemBuilderDTO.getName());
        }
        if(!foodItemBuilderDTO.getDescription().isEmpty()){
            foodItemToEdit.setDescription(foodItemBuilderDTO.getDescription());
        }
        foodItemToEdit.setVeg(foodItemBuilderDTO.isVeg());
        foodItemToEdit.setAvailable(foodItemBuilderDTO.isAvailable());

        if(foodItemBuilderDTO.getPrice() != null){
            foodItemToEdit.setPrice(foodItemBuilderDTO.getPrice());
        }
        if(foodItemBuilderDTO.getRating() != null && foodItemBuilderDTO.getTotalRating() != null){
            foodItemToEdit.setRating(foodItemBuilderDTO.getRating());
            foodItemToEdit.setTotalRatings(foodItemBuilderDTO.getTotalRating());
        }
        if(!foodItemBuilderDTO.getMenuCategoryId().isEmpty()){
            foodItemToEdit.getMenuCategory().getFoodItems().remove(foodItemToEdit);

            MenuCategory menuCategoryToUpdate = menuCategoryRepository.findById(foodItemBuilderDTO.getMenuCategoryId())
                        .orElseThrow(() -> new NoSuchElementException("Menu Category doesn't exist for given Id"));

            foodItemToEdit.setMenuCategory(menuCategoryToUpdate);
        }

        return foodItemRepository.save(foodItemToEdit);
    }

    @Override
    @Transactional
    public void deleteFoodItem(String foodItemId) {
        FoodItem foodItemToEdit = foodItemRepository.findById(foodItemId)
                .orElseThrow(() -> new NoSuchElementException("Food Item doesn't exist for given Id"));

        foodItemToEdit.getMenuCategory().getFoodItems().remove(foodItemToEdit);

        foodItemRepository.delete(foodItemToEdit);
    }

    @Override
    public FoodItem updateFoodItemRating(String foodItemId, Integer customerRating) {
        FoodItem foodItemToEdit = foodItemRepository.findById(foodItemId)
                .orElseThrow(() -> new NoSuchElementException("Food Item doesn't exist for given Id"));

        Double oldRating = foodItemToEdit.getRating();
        Integer oldTotalRatings = foodItemToEdit.getTotalRatings();

        foodItemToEdit.setRating((Double) (oldRating*oldTotalRatings + customerRating) / (oldTotalRatings + 1));
        foodItemToEdit.setTotalRatings(oldTotalRatings + 1);

        return foodItemRepository.save(foodItemToEdit);

    }

    @Override
    public List<FoodItemDTO> fetchFoodItemsDTOsBySearchTermLimit15(String searchTerm) {
        if(searchTerm.isEmpty() || (searchTerm.charAt(0) < 65 || (searchTerm.charAt(0) > 90 && searchTerm.charAt(0) < 97) || searchTerm.charAt(0) > 122)){
            return new ArrayList<>();
        }
        return foodItemConverter.convertToFoodItemDTOList(foodItemRepository.findDistinctFoodItemsBySearchTermLimit15(searchTerm));
    }


}
