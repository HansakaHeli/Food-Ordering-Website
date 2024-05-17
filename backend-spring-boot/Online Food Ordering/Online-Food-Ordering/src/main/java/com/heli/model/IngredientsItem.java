package com.heli.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredients_item")
public class IngredientsItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private int id;

}
