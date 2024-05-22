package com.heli.service;

import com.heli.model.Address;
import com.heli.model.Restaurant;
import com.heli.model.User;
import com.heli.repository.AddressRepository;
import com.heli.repository.RestaurantRepository;
import com.heli.repository.UserRepository;
import com.heli.request.CreateRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest req, User user) {

        //cc
        Address address = addressRepository.save(req.getAddress());

        Restaurant restaurant = new Restaurant();
        restaurant.setAddress(address);
        restaurant.setContactInformation(req.getContactInformation());
        restaurant.setCuisineType(req.getCuisineType());
        restaurant.setImages(req.getImages());
        restaurant.setName(req.getName());
        restaurant.setOpeningHours(req.getOpeningHours());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);
        restaurant.setDescription(req.getDescription());

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(int reataurantId, CreateRestaurantRequest updateRestaurant) throws Exception {

        Restaurant restaurant = findRestaurantById(reataurantId);

        if(restaurant.getCuisineType()!=null){
            restaurant.setCuisineType(updateRestaurant.getCuisineType());
        }
        if(restaurant.getDescription() != null ){
            restaurant.setDescription(updateRestaurant.getDescription());
        }
        if(restaurant.getName() != null){
            restaurant.setName(updateRestaurant.getName());
        }

        return restaurantRepository.save(restaurant);

    }

    @Override
    public void deleteRestaurant(int restaurantId) throws Exception {

        Restaurant restaurant = findRestaurantById(restaurantId);

        restaurantRepository.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        return restaurantRepository.findBySearchQuery(keyword);
    }

    @Override
    public Restaurant findRestaurantById(int id) throws Exception {

        Optional<Restaurant> opt = restaurantRepository.findById(id);

        if(opt.isEmpty()){
            throw new Exception("Restaurant not found with id " + id);
        }

        return opt.get();
    }

    @Override
    public Restaurant getRestaurantByUserId(int userId) throws Exception {

        Restaurant restaurant = restaurantRepository.findByOwnerId(userId);

        if(restaurant == null){
            throw new Exception("Restaurant not found with owner id " + userId);
        }

        return restaurant;

    }

    @Override
    public Restaurant updateRestaurantStatus(int id) throws Exception {

        Restaurant restaurant = findRestaurantById(id);
        restaurant.setOpen(restaurant.isOpen());
        return restaurantRepository.save(restaurant);

    }
}
