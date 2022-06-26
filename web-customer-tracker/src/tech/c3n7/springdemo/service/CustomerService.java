package tech.c3n7.springdemo.service;

import tech.c3n7.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);
}
