package com.NextLeap.Restaurant_Management_Platform_Project.Repositories;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ReviewRepository extends JpaRepository<Review,String> {

//    @Query("SELECT new com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.DTO.ReviewDTO(r.id, r.rating, r.comment, r.customer.userId) FROM Review r WHERE r.restaurant.id = :restaurantId")
//    Page<ReviewDTO> findReviewIdRatingCommentUserIdByRestaurantId(String restaurantId, Pageable pageable);

    Page<Review> findAllByRestaurantId(String restaurantId, Pageable pageable);



}
