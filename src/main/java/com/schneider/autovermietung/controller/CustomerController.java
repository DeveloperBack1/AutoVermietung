package com.schneider.autovermietung.controller;
import com.schneider.autovermietung.entity.Customer;
import com.schneider.autovermietung.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
@Autowired
    public final CustomerService customerService;



    // почему так работает странно?
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
}
