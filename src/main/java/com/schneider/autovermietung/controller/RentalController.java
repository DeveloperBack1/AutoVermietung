package com.schneider.autovermietung.controller;

import com.schneider.autovermietung.entity.Customer;
import com.schneider.autovermietung.entity.Rental;
import com.schneider.autovermietung.service.CarService;
import com.schneider.autovermietung.service.CustomerService;
import com.schneider.autovermietung.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rentals")

public class RentalController {
    private final RentalService rentalService;
    private final CustomerService customerService;
    private final CarService carService;

//    public RentalController(RentalService rentalService, CarService carService,
//                            CustomerService customerService) {
//        this.rentalService = rentalService;
//        this.carService = carService;
//        this.customerService = customerService;
//
//    }

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }




    @PostMapping("/{carId}/{customerId}")
    public Rental rentCar(@PathVariable("carId") Integer carId,
                          @PathVariable("customerId") Customer customerId,
                          @RequestBody Rental rental) {
        return rentalService.rentCar(carId, customerId, rental);

    }

//    @PostMapping("/{carId}/{customerId}")
//    public Rental rentCar(@PathVariable("carId") int carId,
//                          @PathVariable("customerId") int customerId) {
//
//        return rentalService.rentCar(carId, customerId);
//
//    }



}
