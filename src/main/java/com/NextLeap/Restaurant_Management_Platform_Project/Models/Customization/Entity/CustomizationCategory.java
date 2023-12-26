package com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.Entity;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.Entity.FoodItem;
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
@Table(name="customization_categories")
public class CustomizationCategory {

    @Id
    @UuidGenerator
    private String Id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_item_id", referencedColumnName = "id")
    @JsonIgnore
    private FoodItem foodItem;

    @OneToMany(mappedBy = "customizationCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"customizationCategory"})
    @ToString.Exclude
    private List<Customization> customization;
}
