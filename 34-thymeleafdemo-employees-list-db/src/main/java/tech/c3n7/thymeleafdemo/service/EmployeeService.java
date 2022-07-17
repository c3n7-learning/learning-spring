package tech.c3n7.thymeleafdemo.service;

import tech.c3n7.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee employee);

    public void deleteById(int theId);
}
