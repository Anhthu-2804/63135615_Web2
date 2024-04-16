package com.example.csdl_demo.service;

import com.example.csdl_demo.models.Customer;
import com.example.csdl_demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerByID(int id) {
        Optional<Customer> opt = customerRepository.findById(id);
        if (opt.isPresent())
           return opt.get(); // tim thay
        else
            return null;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(int id) {

    }
}
