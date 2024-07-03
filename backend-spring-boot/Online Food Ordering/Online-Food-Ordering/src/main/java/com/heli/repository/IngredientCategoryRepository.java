package com.heli.repository;

import com.heli.model.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory, Integer> {

    List<IngredientCategory> findByRestaurantId(int id);

}
