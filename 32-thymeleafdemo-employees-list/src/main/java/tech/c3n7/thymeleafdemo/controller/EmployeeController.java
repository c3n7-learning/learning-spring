package tech.c3n7.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.c3n7.thymeleafdemo.model.Employee;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    // load employee data
    private List<Employee> employees;

    @PostConstruct
    private void loadData() {
        // create employees
        Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@gmail.com");
        Employee emp2 = new Employee(2, "John", "Adams", "adams@gmail.com");
        Employee emp3 = new Employee(3, "Leary", "Washington", "leary@gmail.com");

        // create the list
        employees= new ArrayList<>();

        // add to list
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        theModel.addAttribute("employees", employees);

        return "list-employees";
    }
}
