package com.postgresspring.Service;

import java.util.List;

import com.postgresspring.Entity.Customer;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);
}