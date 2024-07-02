package com.heli.service;

import com.heli.model.Category;
import com.heli.model.Food;
import com.heli.model.Restaurant;
import com.heli.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(int foodId) throws Exception;

    public List<Food> getRestaurantFood(int restaurantId,
                                        boolean isVegitarian,
                                        boolean isNonveg,
                                        boolean isSeasonal,
                                        String foodCategory
    );

    public List<Food> searchFood(String keyword);

    public Food findFoodbyId(int foodId)throws Exception;

    public Food updateAvailibilityStatus(int foodId)throws Exception;

}
