package com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewBuilderDTO {
    private Integer rating;
    private String comment;
    private String userEmail;

    //Assuming client will send Jwt and the user email

}
