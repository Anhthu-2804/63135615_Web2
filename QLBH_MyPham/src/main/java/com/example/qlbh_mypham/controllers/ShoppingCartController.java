package com.example.qlbh_mypham.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shopping-cart")
public class ShoppingCartController {

    @GetMapping("/views")
    public String viewCarts(Model model) {
        return "Cart/view";
    }

//    @PostMapping("/add/{id}")
//    public String add(@PathVariable("id") int id){
//
//    }
}
