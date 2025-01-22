package com.schneider.autovermietung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schneider.autovermietung.entity.Rental;
import com.schneider.autovermietung.service.RentalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(RentalController.class)
class RentalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RentalService rentalServiceMock;
    

    @Autowired
    private ObjectMapper objectMapper; // Для сериализации/десериализации JSON

    @Test
    void getAllRentals() throws Exception {
        // Создание тестовых данных
        Rental rental1 = new Rental();
        rental1.setId(1);
        rental1.setStartDate(LocalDate.of(2023, 9, 5));
        rental1.setEndDate(LocalDate.of(2023, 9, 10));
        rental1.setTotalCost(500.0);

        Rental rental2 = new Rental();
        rental2.setId(2);
        rental2.setStartDate(LocalDate.of(2023, 10, 1));
        rental2.setEndDate(LocalDate.of(2023, 10, 5));
        rental2.setTotalCost(800.0);

        List<Rental> rentalList = Arrays.asList(rental1, rental2);

        // Настройка мок-сервиса
        when(rentalServiceMock.getAllRentals()).thenReturn(rentalList);

        // Выполнение GET-запроса и проверка ответа
        mockMvc.perform(get("/rentals") // URL контроллера
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Проверка статуса 200 OK
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].startDate").value("2023-09-05"))
                .andExpect(jsonPath("$[0].endDate").value("2023-09-10"))
                .andExpect(jsonPath("$[0].totalCost").value(500.0))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].startDate").value("2023-10-01"))
                .andExpect(jsonPath("$[1].endDate").value("2023-10-05"))
                .andExpect(jsonPath("$[1].totalCost").value(800.0));
    }
  
}