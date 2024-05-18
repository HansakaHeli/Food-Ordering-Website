package com.heli.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Long price;

    @ManyToOne // uni
    @JoinColumn(name = "food_category_id")
    private Category foodCategory;

    @ElementCollection
    @Column(length = 1000)
    private List<String> images;

    @Column(name = "available")
    private boolean available;

    @ManyToOne // bi
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "is_veg")
    private boolean isVegetarian;

    @Column(name = "is_seasonable")
    private boolean isSeasonable;

    @ManyToMany
    private List<IngredientsItem> ingredientItems = new ArrayList<>();

    @Column(name = "creation_date")
    private Date creationDate;
}
