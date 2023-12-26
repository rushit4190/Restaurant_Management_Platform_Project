package com.NextLeap.Restaurant_Management_Platform_Project.Models.Cuisine.Entity;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;


import java.util.Objects;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cuisines")
public class Cuisine {
    @Id
    @UuidGenerator
    private String Id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] poster;

//    @OneToMany(mappedBy = "cuisines", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnoreProperties(value = {"cuisine"})
//    @ToString.Exclude
//    private Set<MenuCategory> menuCategories;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "cuisines")
    @JsonIgnore
    private Set<Restaurant> restaurants;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuisine cuisine = (Cuisine) o;
        return Id != null && Id.equals(cuisine.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
