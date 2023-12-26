package com.NextLeap.Restaurant_Management_Platform_Project.Services.Impl;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.RestaurantImage;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.RestaurantImageRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.RestaurantRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.RestaurantImageService;
import com.NextLeap.Restaurant_Management_Platform_Project.Utility.ConvertBytesArrayToBase64String;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RestaurantImageServiceImpl implements RestaurantImageService {

    private final RestaurantImageRepository restaurantImageRepository;
    private final RestaurantRepository restaurantRepository;
    private final ConvertBytesArrayToBase64String convertBytesArrayToBase64String;
    @Override
    public RestaurantImage uploadRestaurantImage(String restaurantId, MultipartFile imageFile) throws IOException {
        Restaurant restaurantToUpload = restaurantRepository.findById(restaurantId)
                                .orElseThrow(() -> new NoSuchElementException("Restaurant doesnt exist for given Id"));

        RestaurantImage restaurantImageToCreate = RestaurantImage.builder()
                                                .image(imageFile.getBytes())
                                                .restaurant(restaurantToUpload)
                                                .build();

        return restaurantImageRepository.save(restaurantImageToCreate);
    }

    @Override
    public List<String> fetchRestaurantImages(String restaurantId) {

        List<byte[]> restaurantImagesByte =  restaurantImageRepository.findImageByRestaurantId(restaurantId);

        List<String> restaurantImagesString = new ArrayList<>();

        for(byte[] image : restaurantImagesByte){
            restaurantImagesString.add(convertBytesArrayToBase64String.convertToBase64(image));
        }
        return restaurantImagesString;

    }
}
