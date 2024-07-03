package com.heli.repository;

import com.heli.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartitemRepository extends JpaRepository<CartItem, Integer> {
}
