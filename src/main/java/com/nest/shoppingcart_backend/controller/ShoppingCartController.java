package com.nest.shoppingcart_backend.controller;

import com.nest.shoppingcart_backend.dao.UserDao;
import com.nest.shoppingcart_backend.dao.ShoppingCartDao;
import com.nest.shoppingcart_backend.model.User;
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
    private UserDao userDao;
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
    @GetMapping("/view")
    public List<ShoppingCart> view(){
        return (List<ShoppingCart>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List<ShoppingCart> searchPage(@RequestBody ShoppingCart s){
        return (List<ShoppingCart>) dao.searchProduct(s.getName()) ;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> loginPage(@RequestBody User l){
        userDao.save(l);
        HashMap<String ,String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/verify", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> loginVerify(@RequestBody User l){
        List<User> result = (List<User>) userDao.verify(l.getEmail(),l.getPassword());
        HashMap<String ,String> map = new HashMap<>();
        if(result.size()>0){
            String userId = String.valueOf(result.get(0).getId());
            map.put("status","success");
            map.put("userId",userId);
        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userprofile", consumes = "application/json", produces = "application/json")
    public List<User> userProfile(@RequestBody User u){
        return (List<User>) userDao.userProfile(u.getId()) ;
    }
}
