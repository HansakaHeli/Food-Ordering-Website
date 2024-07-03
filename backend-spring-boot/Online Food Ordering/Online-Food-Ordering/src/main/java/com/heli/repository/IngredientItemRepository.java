package com.heli.repository;

import com.heli.model.IngredientsItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientItemRepository extends JpaRepository<IngredientsItem,Integer> {


    List<IngredientsItem> findByRestaurantId(int id);
}
