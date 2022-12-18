package com.postgresspring.Web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.postgresspring.Entity.Customer;
import com.postgresspring.Service.CustomerServiceImpl;

@Controller
public class CustomerController {

    CustomerServiceImpl customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
