package com.NextLeap.Restaurant_Management_Platform_Project.Utility.DTOConverters;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.DTO.CuisineDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.Entity.Cuisine;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CuisineConverter {

    public CuisineDTO convertToCuisineDTO(Cuisine cuisine){
        return CuisineDTO.builder()
                .Id(cuisine.getId())
                .name(cuisine.getName())
                .poster(cuisine.getPoster())
                .build();
    }

    public List<CuisineDTO> convertToCuisineDTOList(List<Cuisine> cuisineList){
        List<CuisineDTO> result = new ArrayList<>();

        for(Cuisine c : cuisineList){
            result.add(convertToCuisineDTO(c));
        }
        return result;
    }
}
