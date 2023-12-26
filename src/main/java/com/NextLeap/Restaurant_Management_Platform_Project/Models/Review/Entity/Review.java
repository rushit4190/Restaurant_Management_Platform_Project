package com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.Entity;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity.User;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reviews")
public class Review {

    @Id
    @UuidGenerator
    private String Id;

    private Integer rating;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant_id", referencedColumnName = "id")
    @JsonIgnore
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "userId")
    @JsonIgnore
    private User customer;

}
