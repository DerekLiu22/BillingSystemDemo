package com.example.billingsystemdemo.services;

import com.example.billingsystemdemo.entity.Customer;
import com.example.billingsystemdemo.repository.CustomerRepository;
import com.example.billingsystemdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CosutmerManager {

    @Autowired
    private CustomerRepository sr;

    public void addNewCustomer(String firstName, String lastName) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(firstName);
        newCustomer.setLastName(lastName);
        sr.save(newCustomer);
    }

    public Customer getCustomerByID(long id){
        return sr.findById(id).get();
    }

    public List<Customer> getCustomerByLastName(String lastName){
        return sr.getCustomerByLastName(lastName);
    }
}
