package com.schneider.autovermitung.repository;

import com.schneider.autovermitung.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}