package com.heli.service;

import com.heli.model.Category;
import com.heli.model.Food;
import com.heli.model.Restaurant;
import com.heli.repository.FoodRepository;
import com.heli.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodRepository foodRepository; // Field Injection

    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {

        Food food = new Food();
        food.setFoodCategory(category);
        food.setRestaurant(restaurant);
        food.setDescription(req.getDescription());
        food.setImages(req.getImages());
        food.setName(req.getName());
        food.setPrice(req.getPrice());
        food.setIngredientItems(req.getIngredients());
        food.setSeasonable(req.isSeasional());
        food.setVegetarian(req.isVegetarin());

        Food savedFood =  foodRepository.save(food);
        restaurant.getFoods().add(savedFood);

        return savedFood;
    }

    @Override
    public void deleteFood(int foodId) throws Exception {

        Food food = findFoodbyId(foodId);
        food.setRestaurant(null);
        foodRepository.save(food);

    }

    @Override
    public List<Food> getRestaurantFood(int restaurantId,
                                        boolean isVegitarian,
                                        boolean isNonveg,
                                        boolean isSeasonal, String foodCategory) {

        List<Food> foods = foodRepository.findByRestaurantId(restaurantId);

        if(isVegitarian){
            foods = filterByVegetarian(foods, isVegitarian);
        }
        if(isNonveg){
            foods = filterByNonveg(foods, isNonveg);
        }
        if(isSeasonal){
            foods = filterBySeasonal(foods,isSeasonal);
        }
        if(foodCategory != null & !foodCategory.equals("")){
            foods = filterByCategory(foods, foodCategory);
        }

        return foods;
    }

    private List<Food> filterByCategory(List<Food> foods, String foodCategory) {
        return foods.stream().filter(food -> {
            if(food.getFoodCategory()!=null){
                return food.getFoodCategory().getName().equals(foodCategory);
            }
            return false;
        }).collect(Collectors.toList());
    }

    private List<Food> filterBySeasonal(List<Food> foods, boolean isSeasonal) {
        return foods.stream().filter(food -> food.isSeasonable()==isSeasonal).collect(Collectors.toList());
    }

    private List<Food> filterByNonveg(List<Food> foods, boolean isNonveg) {
        return foods.stream().filter(food -> food.isVegetarian()==false).collect(Collectors.toList());
    }

    private List<Food> filterByVegetarian(List<Food> foods, boolean isVegitarian) {

        return foods.stream().filter(food -> food.isVegetarian()==isVegitarian).collect(Collectors.toList());

    }

    @Override
    public List<Food> searchFood(String keyword) {
        return foodRepository.searchFood(keyword);
    }

    @Override
    public Food findFoodbyId(int foodId) throws Exception {
        Optional<Food> optionalFood = foodRepository.findById(foodId);

        if(optionalFood.isPresent()){
            throw new Exception("food not exist...");
        }
        return optionalFood.get();
    }

    @Override
    public Food updateAvailibilityStatus(int foodId) throws Exception {

        Food food = findFoodbyId(foodId);
        food.setAvailable(!food.isAvailable());
        return foodRepository.save(food);

    }
}
