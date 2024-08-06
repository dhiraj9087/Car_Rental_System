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
//public class RentalResponseDTO {
//    private Long id;
//    private String carId;
//    private String customerId;
//    private int days;
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
public class RentalResponseDTO {
    private Long id;
    private Long carId;
    private Long customerId;
    private int days;
}
