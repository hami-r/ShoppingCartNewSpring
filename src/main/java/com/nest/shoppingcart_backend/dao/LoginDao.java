package com.nest.shoppingcart_backend.dao;

import com.nest.shoppingcart_backend.model.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoginDao extends CrudRepository<Login,Integer> {

    @Query(value = "SELECT `id`,`address`,`email`,`name`,`password`,`phone_no` FROM `login` WHERE `email` = :email AND `password` = :password",nativeQuery = true)
    List<Login> verify(String email,String password);
}
