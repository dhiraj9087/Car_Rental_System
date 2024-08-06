//package org.example.controller;
//
//import org.example.entities.Rental;
//import org.example.service.RentalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@RestController
//@RequestMapping("/rentals")
//public class RentalController {
//    @Autowired
//    private RentalService rentalService;
//
//    @GetMapping
//    public List<Rental> getAllRentals() {
//        return rentalService.getAllRentals();
//    }
//
//    @GetMapping("/{id}")
//    public Rental getRentalById(@PathVariable Long id) {
//        return rentalService.getRentalById(id);
//    }
//
//    @PostMapping
//    public Rental addRental(@RequestBody Rental rental) {
//        return rentalService.addRental(rental);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteRental(@PathVariable Long id) {
//        rentalService.deleteRental(id);
//    }
//}
////
////@RestController
////@RequestMapping("/rentals")
////public class RentalController {
////    @Autowired
////    private RentalService rentalService;
////
////    @GetMapping
////    public List<Rental> getAllRentals() {
////        return rentalService.getAllRentals();
////    }
////
////    @GetMapping("/{id}")
////    public Rental getRentalById(@PathVariable Long id) {
////        return rentalService.getRentalById(id);
////    }
////// eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYmNkZWYiLCJpYXQiOjE3MjIzNTg5MDcsImV4cCI6MTcyMjM1ODk2N30.0DjF6giVHQfy_5qu5fZMnujIrAVrzEWV6b7QcfYq_FU
////    @PostMapping
////    public Rental addRental(@RequestBody Rental rental) {
////        return rentalService.addRental(rental);
////    }
////
////    @DeleteMapping("/{id}")
////    public void deleteRental(@PathVariable Long id) {
////        rentalService.deleteRental(id);
////    }
////}
package org.example.controller;

import org.example.request.RentalRequestDTO;
import org.example.response.RentalResponseDTO;
import org.example.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @GetMapping
    public List<RentalResponseDTO> getAllRentals() {
        return rentalService.getAllRentals().stream()
                .map(rental -> RentalResponseDTO.builder()
                        .id(rental.getId())
                        .carId(rental.getCar().getCarId())
                        .customerId(rental.getCustomer().getCustomerId())
                        .days(rental.getDays())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RentalResponseDTO getRentalById(@PathVariable Long id) {
        var rental = rentalService.getRentalById(id);
        return RentalResponseDTO.builder()
                .id(rental.getId())
                .carId(rental.getCar().getCarId())
                .customerId(rental.getCustomer().getCustomerId())
                .days(rental.getDays())
                .build();
    }

    @PostMapping
    public RentalResponseDTO addRental(@RequestBody RentalRequestDTO rentalRequestDTO) {
        var rental = rentalService.addRental(rentalRequestDTO);
        return RentalResponseDTO.builder()
                .id(rental.getId())
                .carId(rental.getCar().getCarId())
                .customerId(rental.getCustomer().getCustomerId())
                .days(rental.getDays())
                .build();
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
    }
}
