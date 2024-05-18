package com.heli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "ingredients_item")
public class IngredientsItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne // bi
    @JoinColumn(name = "ingredient_category_id")
    private IngredientCategory category;

    @JsonIgnore
    @ManyToOne // uni
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "is_in_stoke")
    private boolean inStoke = true;

}
