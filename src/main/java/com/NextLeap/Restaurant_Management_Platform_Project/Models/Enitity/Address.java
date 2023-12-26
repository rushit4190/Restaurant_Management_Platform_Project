package com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.springframework.data.geo.Point;

@Embeddable
@Data
public class Address {
    private String city;
    private String area;
    private String street;
    private String houseNo;
    private String buildingNo;
    private String landmark;
    private String pincode;

    @Column(columnDefinition = "POINT")
    private Point location;
}
