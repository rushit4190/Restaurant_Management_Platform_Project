package com.NextLeap.Restaurant_Management_Platform_Project.Utility.DTOConverters;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.DTO.ReviewDTO;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.Entity.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewConverter {

   public ReviewDTO convertToDTO(Review review){
        return ReviewDTO.builder()
                .Id(review.getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .userId(review.getCustomer().getUserId())
                .build();
    }

    public List<ReviewDTO> convertToDTOList(List<Review> reviewList){
       List<ReviewDTO> result = new ArrayList<>();

       for(Review r : reviewList){
           result.add(convertToDTO(r));
       }
       return result;
    }
}
