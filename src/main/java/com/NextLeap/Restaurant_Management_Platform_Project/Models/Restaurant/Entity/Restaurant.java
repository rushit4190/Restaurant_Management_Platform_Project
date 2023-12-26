package com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity;


import com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.Entity.Cuisine;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity.*;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.MenuCategory.Entity.MenuCategory;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.Entity.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.Objects;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="restaurants")
public class Restaurant {

    @Id
    @UuidGenerator
    private String Id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] poster;

    private Double rating;

    private Integer totalRating;

    private Integer averageCost;

    private String phoneNo;

    @Embedded
    private Address restaurantAddress;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "restaurant_cuisine",
            joinColumns = @JoinColumn(name = "restaurant_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cuisine_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties(value = {"id", "description","poster","restaurants"})
    private Set<Cuisine> cuisines ;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private List<MenuCategory> menuCategories;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private List<Review> reviews;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"restaurant","id"})
    @ToString.Exclude
    private List<RestaurantImage> restaurantImages;


    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private List<Order> restaurantOrders;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private List<Cart> restaurantCarts;

    //since we are using Set<Cuisine>
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant restaurant = (Restaurant) o;
        return Id != null && Id.equals(restaurant.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
