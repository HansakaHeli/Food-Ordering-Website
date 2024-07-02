package com.heli.service;

import com.heli.model.Category;
import com.heli.model.Food;
import com.heli.model.Restaurant;
import com.heli.request.CreateFoodRequest;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

}
