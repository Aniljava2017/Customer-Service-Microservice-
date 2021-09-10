package com.progrank.controllers;

import com.progrank.classes.MyOrders;
import com.progrank.entity.Customer;
import com.progrank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer)
    {
        return customerService.saveCust(customer);
    }

    @GetMapping("/myorders/{cid}")
    public MyOrders myProductOrders(@PathVariable("cid") int custId)
    {
        return customerService.getMyOrders(custId);
    }
}
