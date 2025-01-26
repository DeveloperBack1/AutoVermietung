package com.schneider.autovermietung.controller;

import com.schneider.autovermietung.entity.Car;
import com.schneider.autovermietung.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CarController {

    @Autowired
    private final CarService carService;

    @GetMapping("/getAll")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable int id) {
        Car car = carService.getCarById(id);
        return ResponseEntity.status(200).body(car);
    }

    @PostMapping
    public Car saveCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }


}

