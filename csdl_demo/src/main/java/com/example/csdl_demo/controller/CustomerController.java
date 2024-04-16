package com.example.csdl_demo.controller;

import com.example.csdl_demo.models.Customer;
import com.example.csdl_demo.repository.CustomerRepository;
import com.example.csdl_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/customer/all")
    public String getALL(Model model){
        List<Customer> dsKH = customerService.findAllCustomer();
        model.addAttribute("dskh", dsKH);
        return "danhSachKH.html";
    }
}
