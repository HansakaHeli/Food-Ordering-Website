package com.heli.controller;

import com.heli.model.Food;
import com.heli.model.Restaurant;
import com.heli.model.User;
import com.heli.request.CreateFoodRequest;
import com.heli.response.MessageResponse;
import com.heli.service.FoodService;
import com.heli.service.RestaurantService;
import com.heli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization") String jwt) throws Exception{

        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.findRestaurantById(req.getRestaurantId());
        Food food = foodService.createFood(req, req.getCategory(),restaurant);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable int id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception{

        User user = userService.findUserByJwtToken(jwt);

        foodService.deleteFood(id);

        MessageResponse res = new MessageResponse();
        res.setMessage("food deleted successfully");

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Food> updateFoodAvaibilityStatus(@PathVariable int id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception{

        User user = userService.findUserByJwtToken(jwt);

        Food food = foodService.updateAvailibilityStatus(id);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }


}
