package com.heli.service;

import com.heli.model.IngredientCategory;
import com.heli.model.IngredientsItem;

import java.util.List;

public interface IngredientsService {

    public IngredientCategory createIngredientCategory(String name, int restaurantId)throws Exception;

    public IngredientCategory findIngredientCategoryById(int id)throws Exception;

    public List<IngredientCategory> findIngredientCategoryByRestaurantid(int id)throws Exception;

    public IngredientsItem createIngredientItem(int restaurantId, String ingredientName, int categoryid)throws Exception;

    public List<IngredientsItem> findRestaurantsIngredients(int restaurantid);

    public IngredientsItem updateStock(int id)throws Exception;

}
