package tech.c3n7.springdemo.dao;

import tech.c3n7.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();
}
