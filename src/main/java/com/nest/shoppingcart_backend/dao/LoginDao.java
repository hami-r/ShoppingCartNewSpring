package com.nest.shoppingcart_backend.dao;

import com.nest.shoppingcart_backend.model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginDao extends CrudRepository<Login,Integer> {
}
