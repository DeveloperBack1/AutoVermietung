package com.schneider.autovermietung.service.impl;
import com.schneider.autovermietung.entity.Customer;
import com.schneider.autovermietung.repository.CustomerRepository;
import com.schneider.autovermietung.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.schneider.autovermietung.exception.CustomerDoesntExistException;
import com.schneider.autovermietung.exception.error_messages.ErrorMessage;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    public final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {

        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (!optionalCustomer.isPresent()) {
            throw new CustomerDoesntExistException(ErrorMessage.CUSTOMER_NOT_EXIST);
        }
        System.out.println("User: " + optionalCustomer.get());
        Customer customer = optionalCustomer.get();
        return customer;
    }


    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}