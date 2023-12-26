package com.NextLeap.Restaurant_Management_Platform_Project.Models.MenuCategory.Entity;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.FoodItem.Entity.FoodItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.Objects;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="menucategories")
public class MenuCategory {

    @Id
    @UuidGenerator
    private String Id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "menuCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"menucategory"})
    @ToString.Exclude
    private List<FoodItem> foodItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    @JsonIgnore
    private Restaurant restaurant;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cuisine_id", referencedColumnName = "id")
//    @JsonIgnore
//    private Cuisine cuisine;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuCategory menuCategory = (MenuCategory) o;
        return Id != null && Id.equals(menuCategory.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
