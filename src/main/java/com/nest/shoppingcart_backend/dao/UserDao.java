package com.nest.shoppingcart_backend.dao;

import com.nest.shoppingcart_backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User,Integer> {

    @Query(value = "SELECT `id`,`address`,`email`,`name`,`password`,`phone_no` FROM `login` WHERE `email` = :email AND `password` = :password",nativeQuery = true)
    List<User> verify(String email, String password);

    @Query(value = "SELECT `id`,`address`,`email`,`name`,`password`,`phone_no` FROM `login` WHERE `id` =:id",nativeQuery = true)
    List<User> userProfile(Integer id);
}
