package com.schneider.autovermietung.service;

import com.schneider.autovermietung.entity.Customer;
import com.schneider.autovermietung.entity.Rental;

import java.util.List;

public interface RentalService {
    List<Rental> getAllRentals();

    Rental rentCar(Integer carId, Customer customer, Rental rental);
}