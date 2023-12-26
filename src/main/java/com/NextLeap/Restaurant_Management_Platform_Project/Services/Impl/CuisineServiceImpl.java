package com.NextLeap.Restaurant_Management_Platform_Project.Services.Impl;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.DTO.CuisineBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.DTO.CuisineDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.Entity.Cuisine;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.CuisineRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.RestaurantRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.CuisineService;
import com.NextLeap.Restaurant_Management_Platform_Project.Utility.DTOConverters.CuisineConverter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;


@Service
@RequiredArgsConstructor
public class CuisineServiceImpl implements CuisineService {

    private final CuisineRepository cuisineRepository;
    private final RestaurantRepository restaurantRepository;
    private final CuisineConverter cuisineConverter;
    @Override
    public Cuisine addCuisine(CuisineBuilderDTO cuisineBuilderDTO) {
        Cuisine cuisineToAdd = Cuisine.builder()
                               .name(cuisineBuilderDTO.getName())
                               .description(cuisineBuilderDTO.getDescription())
                               .build();
        return cuisineRepository.save(cuisineToAdd);
    }

    @Override
    public Cuisine uploadCuisinePoster(MultipartFile posterFile, String cuisineName) throws IOException {
        Cuisine cuisineToEdit = fetchCuisineByName(cuisineName);

        cuisineToEdit.setPoster(posterFile.getBytes());

        return cuisineRepository.save(cuisineToEdit);
    }

    @Override
    public Restaurant addCuisineToRestaurant(String cuisineName, String restaurantId) {
        Restaurant restaurantToEdit = restaurantRepository.findById(restaurantId).orElseThrow(() -> new NoSuchElementException("Restaurant doesnt exist for given Id"));
        Cuisine cuisineToAdd = fetchCuisineByName(cuisineName);


        restaurantToEdit.getCuisines().add(cuisineToAdd);
        cuisineToAdd.getRestaurants().add(restaurantToEdit);

        cuisineRepository.save(cuisineToAdd);

        return restaurantRepository.save(restaurantToEdit);
    }

    @Override
    public Restaurant removeCuisineFromTheRestaurant(String cuisineName, String restaurantId) {
        Restaurant restaurantToRemove = restaurantRepository.findById(restaurantId).orElseThrow(() -> new NoSuchElementException("Restaurant doesnt exist for given Id"));
        Cuisine cuisineToEdit = fetchCuisineByName(cuisineName);

        cuisineToEdit.getRestaurants().remove(restaurantToRemove);
        restaurantToRemove.getCuisines().remove(cuisineToEdit);

        cuisineRepository.save(cuisineToEdit);
        return restaurantRepository.save(restaurantToRemove);
    }

    @Override
    public Cuisine fetchCuisineById(String cuisineId) {
        Optional<Cuisine> cuisine =  cuisineRepository.findById(cuisineId);

        if(cuisine.isPresent()){
            return cuisine.get();
        }
        else{
            throw new NoSuchElementException("Cuisine not available for the given Id");
        }
    }

    @Override
    public Cuisine fetchCuisineByName(String cuisineName) {
        Optional<Cuisine> cuisine =  cuisineRepository.findByNameIgnoreCase(cuisineName);

        if(cuisine.isPresent()){
            return cuisine.get();
        }
        else{
            throw new NoSuchElementException("Cuisine not available for the given name");
        }
    }

    @Override
    public List<CuisineDTO> fetchCuisineDTOs(Integer pageNo, Integer pageSize) {
        Pageable pageQuery = PageRequest.of(pageNo, pageSize);
        return cuisineConverter.convertToCuisineDTOList( cuisineRepository.findAll(pageQuery).getContent());
    }
}
