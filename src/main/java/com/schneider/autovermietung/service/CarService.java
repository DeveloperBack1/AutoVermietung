package com.schneider.autovermietung.service;
import com.schneider.autovermietung.entity.Car;
import com.schneider.autovermietung.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface CarService {
    Car saveCar(Car car);
    List<Car> findAll();

    Optional<Car> findById(Long id);
    void deleteById(Long id);

    List<Car> getAllCars();

    Car getCarById(int id);




}

