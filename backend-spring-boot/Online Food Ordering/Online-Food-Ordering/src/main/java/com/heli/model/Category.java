package com.heli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "food_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_category_id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne // uni
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;


}
