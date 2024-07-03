package com.heli.service;

import com.heli.model.Category;
import com.heli.model.Restaurant;
import com.heli.repository.CategoryRepisitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CategoryRepisitory categoryRepisitory;


    @Override
    public Category createCategory(String name, int userId) throws Exception {

        Restaurant restaurant = restaurantService.getRestaurantByUserId(userId);
        Category category = new Category();
        category.setName(name);
        category.setRestaurant(restaurant);

        return categoryRepisitory.save(category);

    }

    @Override
    public List<Category> findCategoryByRestaurantId(int id) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantByUserId(id);
        return categoryRepisitory.findByRestaurantId(restaurant.getId());
    }

    @Override
    public Category findCategoryById(int id) throws Exception {

        Optional<Category> optionalCategory = categoryRepisitory.findById(id);

        if (optionalCategory.isEmpty()){
            throw new Exception("category not found");
        }

        return optionalCategory.get();

    }
}
