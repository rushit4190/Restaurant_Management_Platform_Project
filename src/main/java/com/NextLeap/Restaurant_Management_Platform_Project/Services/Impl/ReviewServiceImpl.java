package com.NextLeap.Restaurant_Management_Platform_Project.Services.Impl;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.DTO.ReviewBuilderDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.DTO.ReviewDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.Entity.Review;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity.User;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.RestaurantRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.ReviewRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.UserRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.ReviewService;
import com.NextLeap.Restaurant_Management_Platform_Project.Utility.DTOConverters.ReviewConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewConverter reviewConverter;
    @Override
    public ReviewDTO createReview(String restaurantId, ReviewBuilderDTO reviewBuilderDTO) {
        Restaurant restaurantToEdit = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NoSuchElementException("Restaurant doesn't exist for given Id"));

        User userToEdit = userRepository.findByEmail(reviewBuilderDTO.getUserEmail())
                .orElseThrow(() -> new NoSuchElementException("User doesnt exist for the given email"));

        Review reviewToCreate = Review.builder()
                .rating(reviewBuilderDTO.getRating())
                .comment(reviewBuilderDTO.getComment())
                .customer(userToEdit)
                .restaurant(restaurantToEdit)
                .build();

        reviewRepository.save(reviewToCreate);

        return ReviewDTO.builder()
                             .Id(reviewToCreate.getId())
                             .rating(reviewToCreate.getRating())
                             .comment(reviewToCreate.getComment())
                             .userId(userToEdit.getUserId())
                             .build();
    }

    @Override
    @Transactional
    public void deleteReview(String reviewId) {
        Review reviewToDelete = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new NoSuchElementException("Review doesn't exist for given Id"));

        reviewToDelete.getCustomer().getReviews().remove(reviewToDelete);
        reviewToDelete.getRestaurant().getReviews().remove(reviewToDelete);

        reviewRepository.delete(reviewToDelete);
    }

    @Override
    public List<ReviewDTO> fetchReviewsByRestaurantId(String restaurantId, Integer pageNo, Integer pageSize) {
        Pageable pageQuery = PageRequest.of(pageNo, pageSize);

//        return reviewRepository.findReviewIdRatingCommentUserIdByRestaurantId(restaurantId, pageQuery).getContent();
        return reviewConverter.convertToDTOList(reviewRepository.findAllByRestaurantId(restaurantId,pageQuery).getContent());
    }
}
