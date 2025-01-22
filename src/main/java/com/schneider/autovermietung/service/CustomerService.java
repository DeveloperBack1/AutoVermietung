package com.schneider.autovermietung.service;
import com.schneider.autovermietung.entity.Car;
import com.schneider.autovermietung.entity.Customer;
import com.schneider.autovermietung.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {



List<Customer> findAll();


    Customer getCustomerById(int id);


    Customer saveCustomer(Customer customer);
}
