package com.schneider.autovermitung.controller;

import com.schneider.autovermitung.entity.Rental;
import com.schneider.autovermitung.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @PostMapping("/{carId}/{customerId}")
    public Rental rentCar(@PathVariable("carId") int carId,
                          @PathVariable("customerId") int customerId) {
        return rentalService.rentCar(carId, customerId);

    }
}