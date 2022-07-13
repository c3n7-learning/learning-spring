package tech.c3n7.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.c3n7.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
