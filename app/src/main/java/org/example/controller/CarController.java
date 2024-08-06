//package org.example.controller;
//
//import org.example.entities.Car;
//import org.example.service.CarService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@RestController
//@RequestMapping("/cars")
//public class CarController {
//    @Autowired
//    private CarService carService;
//
//    @GetMapping
//    public List<Car> getAllCars() {
//        return carService.getAllCars();
//    }
//
//    @GetMapping("/{carId}")
//    public Car getCarById(@PathVariable Long carId) {
//        return carService.getCarById(carId);
//    }
//
//    @PostMapping
//    public Car addCar(@RequestBody Car car) {
//        return carService.addCar(car);
//    }
//
//    @DeleteMapping("/{carId}")
//    public void deleteCar(@PathVariable Long carId) {
//        carService.deleteCar(carId);
//    }
//}





package org.example.controller;
import org.example.entities.Car;
import org.example.request.CarRequestDTO;
import org.example.response.CarResponseDTO;
import org.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarResponseDTO> getAllCars() {
        logger.info("Fetching all cars");
        List<Car> cars = carService.getAllCars();
        return cars.stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    @GetMapping("/{carId}")
    public CarResponseDTO getCarById(@PathVariable Long carId) {
        logger.info("Fetching car with ID: {}", carId);
        Car car = carService.getCarById(carId);
        return convertToResponseDTO(car);
    }

    @PostMapping
    public CarResponseDTO addCar(@RequestBody CarRequestDTO carRequestDTO) {
        logger.info("Adding new car: {}", carRequestDTO);
        Car car = convertToEntity(carRequestDTO);
        car = carService.addCar(car);
        return convertToResponseDTO(car);
    }

    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable Long carId) {
        logger.info("Deleting car with ID: {}", carId);
        carService.deleteCar(carId);
    }

    // Conversion methods
    private CarResponseDTO convertToResponseDTO(Car car) {
        CarResponseDTO responseDTO = CarResponseDTO.builder()
                .carId(car.getCarId().toString())
                .carBrand(car.getCarBrand())
                .carModel(car.getCarModel())
                .basePricePerDay(car.getBasePricePerDay())
                .isCarAvailable(car.isCarAvailable())
                .build();
        return responseDTO;
    }


    private Car convertToEntity(CarRequestDTO carRequestDTO) {
        Car car = new Car();
        car.setCarBrand(carRequestDTO.getCarBrand());
        car.setCarModel(carRequestDTO.getCarModel());
        car.setBasePricePerDay(carRequestDTO.getBasePricePerDay());
        car.setCarAvailable(carRequestDTO.isCarAvailable());
        // carId is auto-generated, so no need to set it here
        return car;
    }
}



