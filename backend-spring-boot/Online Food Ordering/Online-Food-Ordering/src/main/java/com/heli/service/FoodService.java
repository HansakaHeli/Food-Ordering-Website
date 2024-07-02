package com.heli.service;

import com.heli.model.Category;
import com.heli.model.Food;
import com.heli.model.Restaurant;
import com.heli.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantFood(Long restaurantId,
                                        boolean isVegitarian,
                                        boolean isNonveg,
                                        boolean isSeasonal,
                                        String foodCategory
    );

    public List<Food> searchFood(String keyword);

    public Food findFoodbyId(Long foodId)throws Exception;

    public Food updateAvailibilityStatus(Long foodId)throws Exception;

}
