package com.heli.repository;

import com.heli.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    public Cart findByCustomerId(int userId);

}
