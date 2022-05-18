package io.learn.demo;

import io.learn.demo.domain.Car;

public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name) {
        return null;
    }

}
