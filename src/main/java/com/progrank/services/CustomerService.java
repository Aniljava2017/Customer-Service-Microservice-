package com.progrank.services;

import com.progrank.classes.MyOrders;
import com.progrank.classes.Product;
import com.progrank.entity.Customer;
import com.progrank.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CustomerService
{
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    RestTemplate restTemplate;

    public Customer saveCust(Customer customer)
    {
        return customerRepo.save(customer);
    }


    public MyOrders getMyOrders(int custId)
    {
        Optional<Customer> customer1=customerRepo.findById(custId);
        int pid= customer1.get().getPid();

        Product product=restTemplate.getForObject("http://localhost:8001/product/"+pid,Product.class );

        MyOrders myOrders=new MyOrders();
        myOrders.setCustomer(customer1.get());
        myOrders.setProduct(product);
        return myOrders;
    }
}