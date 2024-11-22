package com.schneider.autovermitung.controller;
import com.schneider.autovermitung.entity.Customer;
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
    @PostMapping("/{carId}/customer/{customerId}")
    public Rental rentCar(@PathVariable("carId") Long carId,
                          @PathVariable("customerId") Customer customerId,
                          @RequestBody Rental rental) {
            return rentalService.rentCar(carId, customerId, rental);

    }


//    @PostMapping("/{carId}/customer/{customerId}")
//    public Rental rentCar(@PathVariable Long carId, @PathVariable Long customerId, @RequestBody Rental rental) {
//        return rentalService.rentCar(carId, ((Long) customerId, rental);
//    }
}
