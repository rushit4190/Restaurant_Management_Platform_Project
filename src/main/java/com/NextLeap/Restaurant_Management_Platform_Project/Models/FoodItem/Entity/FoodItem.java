package com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.Entity;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.Entity.CustomizationCategory;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.MenuCategory.Entity.MenuCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="food_items")
public class FoodItem {

    @Id
    @UuidGenerator
    private String Id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] poster;

    private boolean veg;

    private Double price;

    //ensure it is 0-5
    private Double rating;

    private Integer totalRatings;

    private boolean available;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_category_id", referencedColumnName = "id")
    @JsonIgnore
    private MenuCategory menuCategory;

    @OneToMany(mappedBy = "foodItem", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"foodItem"})
    @ToString.Exclude
    private List<CustomizationCategory> customizationCategories;
}
