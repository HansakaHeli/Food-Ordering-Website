package com.heli.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @ManyToOne // uni
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_price")
    private Long totalPrice;

    //private List<String> ingredients;



}
