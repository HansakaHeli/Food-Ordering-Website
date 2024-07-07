package com.heli.repository;

import com.heli.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    public List<Order> findByCustomerId(int userId);

    public List<Order> findByRestauratnId(int restaurantId);

}
