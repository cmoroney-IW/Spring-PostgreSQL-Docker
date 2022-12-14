package com.postgresspring;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class PostgresSpringApplication {
    @Autowired
    private CustomerRepository repository; 

	Logger logger
            = Logger.getLogger(
                PostgresSpringApplication.class.getName());
  
    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List<Customer> allCustomers = this.repository.findAll(); 
        logger.info("Number of customers: " + allCustomers.size());
 
        Customer newCustomer = new Customer(); 
        newCustomer.setFirstName("John"); 
        newCustomer.setLastName("Doe"); 
        logger.info("Saving new customer..."); 
        this.repository.save(newCustomer); 
 
        allCustomers = this.repository.findAll(); 
        logger.info("Number of customers: " + allCustomers.size());
    }
}
