package com.schneider.autovermietung.service;

import com.schneider.autovermietung.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer getCustomerById(int id);

    Customer saveCustomer(Customer customer);
}