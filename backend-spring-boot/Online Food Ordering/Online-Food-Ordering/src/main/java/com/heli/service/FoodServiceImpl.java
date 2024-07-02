package com.heli.service;

import com.heli.model.Category;
import com.heli.model.Food;
import com.heli.model.Restaurant;
import com.heli.repository.FoodRepository;
import com.heli.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {
        return null;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {

    }

    @Override
    public List<Food> getRestaurantFood(Long restaurantId, boolean isVegitarian, boolean isNonveg, boolean isSeasonal, String foodCategory) {
        return null;
    }

    @Override
    public List<Food> searchFood(String keyword) {
        return null;
    }

    @Override
    public Food findFoodbyId(Long foodId) throws Exception {
        return null;
    }

    @Override
    public Food updateAvailibilityStatus(Long foodId) throws Exception {
        return null;
    }
}
