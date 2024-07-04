package com.vadel.customerservice.Controller;

import com.vadel.customerservice.Entity.Customer;
import com.vadel.customerservice.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;



    @GetMapping(path = "/customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping(path = "/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).orElse(null);
    }
}
