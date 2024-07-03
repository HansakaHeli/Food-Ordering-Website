package com.heli.service;

import com.heli.model.Category;

import java.util.List;

public interface CategoryService {

    public Category createCategory(String name, int userId) throws Exception;

    public List<Category> findCategoryByRestaurantId(int id)throws Exception;

    public Category findCategoryById(int id)throws Exception;
}
