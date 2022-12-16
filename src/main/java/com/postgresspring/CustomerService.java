package com.postgresspring;

public interface CustomerService {
    Customer getCustomer(Long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);

}