package com.heli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredient_category")
public class IngredientCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_category_id")
    private int id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToOne // uni
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL) // bi
    private List<IngredientsItem> ingredientsItems = new ArrayList<>();

}
