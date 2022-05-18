package io.learn.demo;

import static org.mockito.BDDMockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import io.learn.demo.domain.Car;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService CarService;

    @Test
    public void getCar_ShouldReturnCar() throws Exception {

        BDDMockito.given(CarService.getCarDetails(anyString())).willReturn(new Car("Kia", "Petrol DCT"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/Kia"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Kia"));
    }

    @Test
    public void getCar_notFound() throws Exception{
        given(CarService.getCarDetails(anyString())).willThrow(new CarNotFoundException());
        
        mockMvc.perform(MockMvcRequestBuilders.get("/cars/Kia"))
                .andExpect(status().isNotFound());
    }

}
