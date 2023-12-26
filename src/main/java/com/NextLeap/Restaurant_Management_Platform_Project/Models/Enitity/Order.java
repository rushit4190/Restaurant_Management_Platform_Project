package com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity;

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
@Table(name="orders")
public class Order {
    @Id
    @UuidGenerator
    private String Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    @JsonIgnore
    private Restaurant restaurant;
}
