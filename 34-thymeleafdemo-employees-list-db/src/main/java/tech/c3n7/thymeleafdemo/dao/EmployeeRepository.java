package tech.c3n7.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.c3n7.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
