package com.example.csdl_demo.service;

import com.example.csdl_demo.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();
    Customer findCustomerByID(int id);
    void addCustomer(Customer customer);
    void deleteCustomer(int id);
}
