package com.schneider.autovermietung.service.impl;

import com.schneider.autovermietung.entity.Car;
import com.schneider.autovermietung.repository.CarRepository;
import com.schneider.autovermietung.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;


    public Car getCarById(Integer id) {
        return carRepository.findById(id).orElse(new Car());
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(int id) {
        return null;
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> findAll() {
        return List.of();
    }

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}
