package com.schneider.autovermitung.service;
//iimport org.springframework.stereotype.Service;

import com.schneider.autovermitung.entity.Car;
import com.schneider.autovermitung.entity.Customer;
import com.schneider.autovermitung.entity.Rental;
import com.schneider.autovermitung.repository.CarRepository;
import com.schneider.autovermitung.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;

    public RentalService(RentalRepository rentalRepository, CarRepository carRepository) {
        this.rentalRepository = rentalRepository;
        this.carRepository = carRepository;
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental rentCar(Long carId, Customer customer, Rental rental) {
        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
        if (!car.isAvailable()) {
            throw new RuntimeException("Car is not available");
        }
        car.setAvailable(false);

        long days = ChronoUnit.DAYS.between(rental.getStartDate(), rental.getEndDate());
        rental.setTotalCost(days * car.getPricePerDay());
        rental.setCar(car);
        rental.setCustomer(customer);

        carRepository.save(car);
        return rentalRepository.save(rental);
    }
}


