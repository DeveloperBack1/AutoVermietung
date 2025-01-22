package com.schneider.autovermietung.service.impl;

import com.schneider.autovermietung.entity.Car;
import com.schneider.autovermietung.entity.Customer;
import com.schneider.autovermietung.entity.Rental;
import com.schneider.autovermietung.repository.CarRepository;
import com.schneider.autovermietung.repository.CustomerRepository;
import com.schneider.autovermietung.repository.RentalRepository;
import com.schneider.autovermietung.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

//    public RentalService(RentalRepository rentalRepository, CarRepository carRepository) {
//        this.rentalRepository = rentalRepository;
//        this.carRepository = carRepository;
//    }
@Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

//    @Override
//    public Rental rentCar(Rental rental) {
//        return null;
//    }

@Override
    public Rental rentCar(Integer carId, Customer customer, Rental rental) {
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
