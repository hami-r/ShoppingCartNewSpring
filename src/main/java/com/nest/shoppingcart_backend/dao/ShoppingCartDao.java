package com.nest.shoppingcart_backend.dao;

import com.nest.shoppingcart_backend.model.ShoppingCart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShoppingCartDao extends CrudRepository<ShoppingCart,Integer> {

    @Query(value = "SELECT `id`,`category`,`description`,`image`,`name`,`price` FROM `products` WHERE `name` LIKE %:name%", nativeQuery = true)
    List<ShoppingCart> searchProduct(String name);
}
