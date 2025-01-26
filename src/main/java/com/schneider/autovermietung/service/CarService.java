package com.schneider.autovermietung.service;

import com.schneider.autovermietung.entity.Car;

import java.util.List;

public interface CarService {
    Car saveCar(Car car);
    List<Car> getAllCars();
    Car getCarById(int id);
}