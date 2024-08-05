package com.heli.repository;

import com.heli.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query("SELECT r FROM Restaurant r WHERE lower(r.name) LIKE lower(concat('%', :query, '%')) " + "OR lower(r.cuisineType) LIKE (concat('%', :query, '%') ) ")
    List<Restaurant> findBySearchQuery(String query);
    Restaurant findByOwnerId(int userId);

    @Query("SELECT r.vote FROM Restaurant r WHERE r.id = :restaurantId")
    Integer findVoteCountByRestaurantId(int restaurantId);

}
