package com.heli.service;

import com.heli.model.Restaurant;
import com.heli.model.User;
import com.heli.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {

    public Restaurant createRestaurant(CreateRestaurantRequest req, User user);

    public Restaurant updateRestaurant(int reataurantId, CreateRestaurantRequest updateRestaurant) throws Exception;

    public void deleteRestaurant(int restaurantId)throws Exception;

    public List<Restaurant> getAllRestaurant(); // only admin can do this

    public List<Restaurant> searchRestaurant(String keyword);

    public Restaurant findRestaurantById(int id) throws Exception;

    public Restaurant getRestaurantByUserId(int userId) throws Exception;

    // Adding favourite (look this)

    public Restaurant updateRestaurantStatus(int id) throws Exception; // Weather open or close

    public Integer getVoteCountByRestaurantId(int restaurantId);

}
