//package org.example.request;
//
//public class CarRequestDTO {
//    private String carId;
//    private String carBrand;
//    private String carModel;
//    private double basePricePerDay;
//    private boolean isCarAvailable;
//
//    // Getters and setters
//}

package org.example.request;

public class CarRequestDTO {
    private String carBrand;
    private String carModel;
    private double basePricePerDay;
    private boolean isCarAvailable;

    // Getters and setters
    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public void setBasePricePerDay(double basePricePerDay) {
        this.basePricePerDay = basePricePerDay;
    }

    public boolean isCarAvailable() {
        return isCarAvailable;
    }

    public void setCarAvailable(boolean carAvailable) {
        isCarAvailable = carAvailable;
    }
}
