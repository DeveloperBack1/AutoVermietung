package com.schneider.autovermitung.repository;

import com.schneider.autovermitung.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
