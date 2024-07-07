package com.heli.service;

import com.heli.model.Address;
import com.heli.model.Order;
import com.heli.model.Restaurant;
import com.heli.model.User;
import com.heli.repository.*;
import com.heli.request.OrderRequest;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CartService cartService;

    @Override
    public Order createOrder(OrderRequest order, User user) throws Exception {

        Address shipAddress = order.getDeliveryAddress();

        Address savedAddress = addressRepository.save(shipAddress);

        if(!user.getAddresses().contains(savedAddress)){
            user.getAddresses().add(savedAddress);
            userRepository.save(user);
        }

        Restaurant restaurant = restaurantService.findRestaurantById(order.getRestaurantId());

        Order createOrder = new Order();
        createOrder.setCustomer(user);
        createOrder.setCreatedAt(new Date());
        createOrder.setOrderStatus("PENDING");
        createOrder.setDeliveryAddress(savedAddress);
        createOrder.setRestaurant(restaurant);


    }

    @Override
    public Order updateOrder(int orderId, String orderStatus) throws Exception {
        return null;
    }

    @Override
    public void cancelOrder(int orderId) throws Exception {

    }

    @Override
    public List<Order> getUserOrders(int userId) throws Exception {
        return null;
    }

    @Override
    public List<Order> getRestaurantOrder(int restaurantId, String orderStatus) throws Exception {
        return null;
    }
}

// solve errors