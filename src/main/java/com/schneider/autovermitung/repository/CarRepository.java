package com.schneider.autovermitung.repository;


import com.schneider.autovermitung.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

