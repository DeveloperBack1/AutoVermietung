package com.schneider.autovermitung.service;

import com.schneider.autovermitung.entity.Car;
import com.schneider.autovermitung.entity.Customer;
import com.schneider.autovermitung.entity.Rental;
import com.schneider.autovermitung.repository.CarRepository;
import com.schneider.autovermitung.repository.CustomerRepository;
import com.schneider.autovermitung.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalService {
    public final RentalRepository rentalRepository;
    public final CarRepository carRepository;
    public final CustomerRepository customerRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental rentCar(int carId, int customerId) {
        Rental rental = new Rental();
        Optional<Car> car = carRepository.findById(carId);
        if (car.isPresent()) {
            rental.setCar(car.get());
        }

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isPresent()) {
            rental.setCustomer(optionalCustomer.get());
        }

        rental = rentalRepository.save(rental);

        return rental;
    }
}