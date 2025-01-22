package com.schneider.autovermietung.repository;

import com.schneider.autovermietung.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {



  /*  Optional<Customer> findById();*/
}
