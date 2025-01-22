package com.schneider.autovermietung.service;
import org.springframework.stereotype.Service;

import com.schneider.autovermietung.entity.Car;
import com.schneider.autovermietung.entity.Customer;
import com.schneider.autovermietung.entity.Rental;
import com.schneider.autovermietung.repository.CarRepository;
import com.schneider.autovermietung.repository.CustomerRepository;
import com.schneider.autovermietung.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public interface RentalService {
   List<Rental>getAllRentals();
   Rental rentCar(Integer carId, Customer customer, Rental rental);

}

//
//    public List<Rental> getAllRentals() {
//        return rentalRepository.findAll();
//    }
//
//    public Rental rentCar(int carId, int customerId) {
//        Rental rental = new Rental();
//        Optional<Car> car = carRepository.findById(carId);
//        rental.setCar(car.get());
//
//        Optional<Customer> customer = customerRepository.findById(customerId);
//        if (customer.isPresent()) {
//            rental.setCustomer(customer.get());
//        }
//        rental = rentalRepository.save(rental);
//        return rental;
//
//
//
//
//    }
//
//
//
//

//}


