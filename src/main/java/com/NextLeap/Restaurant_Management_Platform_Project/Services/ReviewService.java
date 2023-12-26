package com.NextLeap.Restaurant_Management_Platform_Project.Services;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.DTO.ReviewBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.DTO.ReviewDTO;

import java.util.List;

public interface ReviewService {

    ReviewDTO createReview(String restaurantId, ReviewBuilderDTO reviewBuilderDTO);

    void deleteReview(String reviewId);

    List<ReviewDTO> fetchReviewsByRestaurantId(String restaurantId, Integer pageNo, Integer pageSize);
}
