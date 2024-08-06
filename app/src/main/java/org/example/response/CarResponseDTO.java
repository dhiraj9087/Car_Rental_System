//package org.example.response;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class CarResponseDTO {
//    private String carId;
//    private String carBrand;
//    private String carModel;
//    private double basePricePerDay;
//    private boolean isCarAvailable;
//
//    // Getters and setters
//}


package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarResponseDTO {
    private String carId;
    private String carBrand;
    private String carModel;
    private double basePricePerDay;
    private boolean isCarAvailable;

    // Getters and setters
}
