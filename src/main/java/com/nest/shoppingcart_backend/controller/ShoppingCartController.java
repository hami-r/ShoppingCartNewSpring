package com.nest.shoppingcart_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartController {
    @GetMapping("/")
    public String homePage(){
        return "Welcome to my website";
    }

    @PostMapping(path = "/add",consumes = "application/json", produces = "application/json")
    public String addPage(){
        return "add page";
    }
}
