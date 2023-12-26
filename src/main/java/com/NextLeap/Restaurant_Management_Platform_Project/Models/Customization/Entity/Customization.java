package com.NextLeap.Restaurant_Management_Platform_Project.Models.Customization.Entity;

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
@Table(name="customization")
public class Customization {
    @Id
    @UuidGenerator
    private String Id;

    private String name;
    private Double priceModifier;
    private boolean available;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customization_category", referencedColumnName = "id")
    @JsonIgnore
    private CustomizationCategory customizationCategory;
}
