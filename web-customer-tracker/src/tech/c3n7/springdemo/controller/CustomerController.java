package tech.c3n7.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.c3n7.springdemo.dao.CustomerDAO;
import tech.c3n7.springdemo.entity.Customer;

import java.util.List;

// https://stackoverflow.com/q/16428126
@Controller
@RequestMapping("/customer")
public class CustomerController {

    // Inject the DAO
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {
        // get customers from the dao
        List<Customer> theCustomers = customerDAO.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customer", theCustomers);

        return "list-customers";
    }
}
