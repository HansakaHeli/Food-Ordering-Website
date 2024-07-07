package com.heli.service;

import com.heli.model.Order;
import com.heli.model.User;
import com.heli.request.OrderRequest;

import java.util.List;

public interface OrderService {

    public Order createOrder(OrderRequest order, User user) throws Exception ;

    public Order updateOrder(int orderId, String orderStatus)throws Exception;

    public void cancelOrder(int orderId)throws Exception;

    public List<Order> getUserOrders(int userId)throws Exception;

    public List<Order> getRestaurantOrder(int restaurantId, String orderStatus)throws Exception;

}
