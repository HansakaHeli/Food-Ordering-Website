package com.heli.repository;

import com.heli.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepisitory extends JpaRepository<Category, Integer> {


    public List<Category> findByRestaurantId(int id);


}
