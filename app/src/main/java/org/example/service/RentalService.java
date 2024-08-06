//package org.example.service;
//
//import org.example.entities.Rental;
//import org.example.repository.RentalRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class RentalService {
//    @Autowired
//    private RentalRepository rentalRepository;
//
//    public List<Rental> getAllRentals() {
//        return rentalRepository.findAll();
//    }
//
//    public Rental getRentalById(Long id) {
//        return rentalRepository.findById(id).orElse(null);
//    }
//
//    public Rental addRental(Rental rental) {
//        return rentalRepository.save(rental);
//    }
//
//    public void deleteRental(Long id) {
//        rentalRepository.deleteById(id);
//    }
//}
package org.example.service;

import org.example.entities.Car;
import org.example.entities.Customer;
import org.example.entities.Rental;
import org.example.repository.CarRepository;
import org.example.repository.CustomerRepository;
import org.example.repository.RentalRepository;
import org.example.request.RentalRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public Rental addRental(RentalRequestDTO rentalRequestDTO) {
        Car car = carRepository.findById(rentalRequestDTO.getCarId()).orElseThrow();
        Customer customer = customerRepository.findById(rentalRequestDTO.getCustomerId()).orElseThrow();
        Rental rental = new Rental();
        rental.setCar(car);
        rental.setCustomer(customer);
        rental.setDays(rentalRequestDTO.getDays());
        return rentalRepository.save(rental);
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}
