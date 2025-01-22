package com.schneider.autovermietung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schneider.autovermietung.entity.Car;
import com.schneider.autovermietung.service.CarService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;
@SpringBootTest
@WebMvcTest(CarController.class)

class CarControllerTest {


    @Autowired
    private MockMvc mockMvc; // для имитации запросов пользователей

    @MockBean
    private CarService carServiceMock;

    @Autowired
    private ObjectMapper objectMapper;
    //
    private List<Car> carList;


    @Test
    void getAllCars() throws Exception {
        when(carServiceMock.getAllCars()).thenReturn(List.of(new Car(1,
                "BMW", "5", 20.5, true)));
        this.mockMvc.perform(get("/cars"))
                .andDo(print()) //печать лога вызова
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..model").exists())
                .andExpect(jsonPath("$..pricePerDay").value(20.5))
                .andExpect(jsonPath("$..brand").value("5"));
    }


    @Test
    void saveCar() throws Exception {
        Car carToSave = new Car(2, "Ford", "Focus",
                25.5, true);

        when(carServiceMock.saveCar(any(Car.class))).thenReturn(carToSave);

        mockMvc.perform(post("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carToSave)))
                .andExpect(status().isOk()) // Ожидаем статус 200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.model").value("Ford"));


    }

    @Test
    public void testGetCarById() throws Exception {

    int id = 1;
        // Mock the carService to return the Car object
        when(carServiceMock.getCarById(anyInt())).thenReturn(new Car(1,"BMW",
                "5", 20.5, true));

        // Act & Assert: Perform GET request and verify response
        mockMvc.perform(get("/cars/{id}",id).
                        contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // Verify HTTP status is 200
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.model").value("BMW"))
                .andExpect(jsonPath("$.brand").value("5"))
                .andExpect(jsonPath("$.pricePerDay").value(20.5))
                .andExpect(jsonPath("$.available").value(true));
    }


}


