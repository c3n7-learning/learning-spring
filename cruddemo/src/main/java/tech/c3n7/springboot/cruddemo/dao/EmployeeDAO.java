package tech.c3n7.springboot.cruddemo.dao;

import tech.c3n7.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
