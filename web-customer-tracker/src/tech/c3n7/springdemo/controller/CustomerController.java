package tech.c3n7.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.c3n7.springdemo.entity.Customer;
import tech.c3n7.springdemo.service.CustomerService;

import java.util.List;

// https://stackoverflow.com/q/16428126
@Controller
@RequestMapping("/customer")
public class CustomerController {

    // Inject the DAO
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        // get customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customer", theCustomers);

        return "list-customers";
    }
}
