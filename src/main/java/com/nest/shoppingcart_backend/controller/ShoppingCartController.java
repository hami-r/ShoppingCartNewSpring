package com.nest.shoppingcart_backend.controller;

import com.nest.shoppingcart_backend.dao.LoginDao;
import com.nest.shoppingcart_backend.dao.ShoppingCartDao;
import com.nest.shoppingcart_backend.model.Login;
import com.nest.shoppingcart_backend.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartDao dao;
    @Autowired
    private LoginDao loginDao;
    @GetMapping("/")
    public String homePage(){
        return "Welcome to my website";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addPage(@RequestBody ShoppingCart s){
        dao.save(s);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/view", consumes = "application/json", produces = "application/json")
    public List<ShoppingCart> viewPage(@RequestBody ShoppingCart s){
        System.out.println(s.getName());
        return (List<ShoppingCart>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List<ShoppingCart> searchPage(@RequestBody ShoppingCart s){
        return (List<ShoppingCart>) dao.searchProduct(s.getName()) ;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> loginPage(@RequestBody Login l){
        loginDao.save(l);
        HashMap<String ,String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }
}
