package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;
    private String carBrand;
    private String carModel;
    private double basePricePerDay;
    private boolean isCarAvailable;

    // Getters and setters
}
//@Entity
//public class Car {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String carId;
//    private String carBrand;
//    private String carModel;
//    private double basePricePerDay;
//    private boolean isCarAvailable;
//
//    // Getters and setters
//}
