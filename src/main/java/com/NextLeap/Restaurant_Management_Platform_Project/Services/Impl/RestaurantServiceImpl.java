package com.NextLeap.Restaurant_Management_Platform_Project.Services.Impl;

import com.NextLeap.Restaurant_Management_Platform_Project.Exceptions.CustomException;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.DTO.RestaurantBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.DTO.RestaurantDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.DTO.RestaurantOverviewDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.Entity.Cuisine;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.MenuCategory.Entity.MenuCategory;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.Entity.Review;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.RestaurantRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.RestaurantService;
import com.NextLeap.Restaurant_Management_Platform_Project.Utility.DTOConverters.RestaurantConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantConverter restaurantConverter;
    @Override
    public Restaurant createRestaurant(RestaurantBuilderDTO restaurantBuilderDTO) {
        //Assuming restaurantBuilderDTO will have all appropriate fields that are required
        // Zero rating implies new restaurant

        Restaurant restaurantToAdd = Restaurant.builder()
                                    .name(restaurantBuilderDTO.getName())
                                    .description(restaurantBuilderDTO.getDescription())
                                    .averageCost(restaurantBuilderDTO.getAverageCost())
                                    .phoneNo(restaurantBuilderDTO.getPhoneNo())
                                    .rating(restaurantBuilderDTO.getRating())
                                    .totalRating(restaurantBuilderDTO.getTotalRating())
                                    .restaurantAddress(restaurantBuilderDTO.getRestaurantAddress())
                                    .build();
        return restaurantRepository.save(restaurantToAdd);
    }

    @Override
    public Restaurant updateRestaurant(String restaurantId, RestaurantBuilderDTO restaurantBuilderDTO) {
        Restaurant restaurantToUpdate = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NoSuchElementException("Restaurant doesnt exist for given Id"));

        if(!restaurantBuilderDTO.getName().isEmpty()){
            restaurantToUpdate.setName(restaurantBuilderDTO.getName());
        }
        if(!restaurantBuilderDTO.getDescription().isEmpty()){
            restaurantToUpdate.setDescription(restaurantBuilderDTO.getDescription());
        }
        if(restaurantBuilderDTO.getAverageCost() != null){
            restaurantToUpdate.setAverageCost(restaurantBuilderDTO.getAverageCost());
        }
        if(!restaurantBuilderDTO.getPhoneNo().isEmpty()){
            restaurantToUpdate.setPhoneNo(restaurantBuilderDTO.getPhoneNo());
        }
        if(restaurantBuilderDTO.getRating() != null && restaurantBuilderDTO.getTotalRating() != null){
            restaurantToUpdate.setRating(restaurantBuilderDTO.getRating());
            restaurantToUpdate.setTotalRating(restaurantBuilderDTO.getTotalRating());
        }

        if(restaurantBuilderDTO.getRestaurantAddress() != null){
            restaurantToUpdate.setRestaurantAddress(restaurantBuilderDTO.getRestaurantAddress());
        }

        return restaurantRepository.save(restaurantToUpdate);
    }

    @Override
    @Transactional
    public void deleteRestaurant(String restaurantId) {
        Restaurant restaurantToDelete = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NoSuchElementException("Restaurant doesnt exist for given Id"));

        //delete restaurant from cuisine's list
        if(!restaurantToDelete.getCuisines().isEmpty()) {
            for (Cuisine c : restaurantToDelete.getCuisines()) {
                c.getRestaurants().remove(restaurantToDelete);
            }
            restaurantToDelete.getCuisines().clear();
        }
        //ensure user and review are disconnected.
        for(Review reviewToDelete : restaurantToDelete.getReviews()){
            reviewToDelete.getCustomer().getReviews().remove(reviewToDelete);
        }

        restaurantRepository.delete(restaurantToDelete);

    }

    @Override
    public Restaurant uploadRestaurantPoster(MultipartFile posterFile, String restaurantId) throws IOException,NoSuchElementException {
        Restaurant restaurantToEdit = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NoSuchElementException("Restaurant doesnt exist for given Id"));

        restaurantToEdit.setPoster(posterFile.getBytes());

        return restaurantRepository.save(restaurantToEdit);
    }

    @Override
    public Restaurant updateRestaurantRating(String restaurantId, Integer customerRating) {
        Restaurant restaurantToUpdate = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NoSuchElementException("Restaurant doesnt exist for given Id"));
        Double oldRating = restaurantToUpdate.getRating();
        Integer oldTotalRating = restaurantToUpdate.getTotalRating();

        restaurantToUpdate.setRating((Double) (oldRating * oldTotalRating + customerRating) / (oldTotalRating + 1));
        restaurantToUpdate.setTotalRating(oldTotalRating+1);
        return restaurantRepository.save(restaurantToUpdate);
    }

    @Override
    public RestaurantOverviewDTO fetchRestaurantById(String restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NoSuchElementException("Restaurant doesnt exist for given Id"));

        return restaurantConverter.convertToRestaurantOverviewDTO(restaurant);

    }



    @Override
    public RestaurantOverviewDTO fetchRestaurantByName(String restaurantName) {
        Optional<Restaurant> restaurant =  restaurantRepository.findByNameIgnoreCase(restaurantName);

        if(restaurant.isPresent()){
            return restaurantConverter.convertToRestaurantOverviewDTO( restaurant.get());
        }
        else{
            throw new NoSuchElementException("Restaurant not available for the given name");
        }
    }

    @Override
    public List<MenuCategory> fetchRestaurantMenuById(String restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NoSuchElementException("Restaurant doesnt exist for given Id"));
        return restaurant.getMenuCategories();
    }

    @Override
    public List<RestaurantDTO> fetchRestaurantDTOs(Integer pageNo, Integer pageSize) {
        Pageable pageQuery = PageRequest.of(pageNo, pageSize);

        return restaurantConverter.convertToRestaurantDTOList( restaurantRepository.findAll(pageQuery).getContent());
    }

    @Override
    public List<RestaurantDTO> fetchTopRestaurantDTOs(Integer pageNo, Integer pageSize) {
        Pageable pageQuery = PageRequest.of(pageNo, pageSize);

        return restaurantConverter.convertToRestaurantDTOList( restaurantRepository.findByOrderByRatingDesc(pageQuery).getContent());
    }

    @Override
    public List<RestaurantDTO> fetchRestaurantDTOsWithFilters(
            String cuisines,
            Double ratingThreshold, Integer averageCostMin,
            Integer averageCostMax, String sortBy, String sortOrder, Integer pageNo, Integer pageSize) throws CustomException {

//        Pageable pageQuery = PageRequest.of(pageNo, pageSize);
//        Since we are using native query, we are converting pageNo and pageSize to limit and offset
//        Another way to enable pagination for native queries is by declaring an additional attribute countQuery.

        List<String> cuisineNames = Arrays.asList(cuisines.split(",")) ;
        Integer cuisineSize = cuisines.isEmpty() ? 0 : cuisineNames.size();

        Integer limit = pageSize;
        Integer offSet = limit * pageNo;

        try {
            return restaurantConverter.convertToRestaurantDTOList(
                    restaurantRepository.findRestaurantsWithFilters(cuisineNames, cuisineSize, ratingThreshold, averageCostMin, averageCostMax,
                            sortBy, sortOrder, limit, offSet));
        }catch(Exception e){
            throw new CustomException("Custom exception in Restaurant repository : " + e.getMessage());
        }
    }

    @Override
    public List<RestaurantDTO> fetchRestaurantDTOsByCuisines(String cuisines, Integer pageNo, Integer pageSize) throws CustomException {

        if(cuisines.isEmpty()){
            return new ArrayList<>();
        }

        List<String> cuisineNames = Arrays.asList(cuisines.split(",")) ;
        Integer limit = pageSize;
        Integer offSet = limit * pageNo;

        try {
            return restaurantConverter.convertToRestaurantDTOList(restaurantRepository
                    .findByCuisinesNameIn(cuisineNames,limit, offSet));
        }catch(Exception e){
            throw new CustomException("Custom exception in Restaurant repository : " + e.getMessage());
        }
    }

    @Override
    public List<RestaurantDTO> fetchRestaurantDTOsBySearchTermLimit10(String searchTerm) {
        if(searchTerm.isEmpty() || (searchTerm.charAt(0) < 65 || (searchTerm.charAt(0) > 90 && searchTerm.charAt(0) < 97) || searchTerm.charAt(0) > 122)){
            return new ArrayList<>();
        }
        return restaurantConverter.convertToRestaurantDTOList(restaurantRepository.findRestaurantsBySearchTermLimit10(searchTerm));
    }
}
