package io.learn.demo;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import io.learn.demo.domain.Car;

public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;



    @Test
    public void getCar_ShouldReturnCar() throws Exception {

        carService = new CarService(carRepository);

        BDDMockito.given(carRepository.findByName("Kia")).willReturn(new Car("Kia", "Petrol DCT"));

        Car car = carService.getCarDetails("Kia");

        assert (car.getName()).equals("Kia");
        assert (car.getType()).equals("Petrol DCT");

    }

}
