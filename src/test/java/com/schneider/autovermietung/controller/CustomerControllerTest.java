package com.schneider.autovermietung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schneider.autovermietung.entity.Car;
import com.schneider.autovermietung.entity.Customer;
import com.schneider.autovermietung.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerServiceMock;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getCustomerById() throws Exception {
        when(customerServiceMock.getCustomerById(anyInt())).thenReturn((new Customer(1,
                "Anton", "anton@yahoo.com")));
        this.mockMvc.perform(get("/customers/{id}", 1))
                .andDo(print()) //печать лога вызова
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..name").exists())
                .andExpect(jsonPath("$..id").value(1))
                .andExpect(jsonPath("$..email").value("anton@yahoo.com"));
    }

    @Test
    public void testSaveCustomer() throws Exception {
        //  создаём объект Customer
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Alex");
        customer.setEmail("alex@mail.com");

        // Мокаем поведение customerService
        when(customerServiceMock.saveCustomer(any(Customer.class))).thenReturn(customer);

        //  отправляем POST-запрос и проверяем результат
        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer))) // Конвертация объекта в JSON
                .andExpect(status().isOk()) // Проверка на статус 200 OK
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Alex"))
                .andExpect(jsonPath("$.email").value("alex@mail.com"));
    }

}