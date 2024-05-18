package com.heli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cart_item")

public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private int id;

    @ManyToOne //bi
    @JsonIgnore
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "quantity")
    private int quantity;

    @ElementCollection
    @Column(length = 1000)
    private List<String> ingredeints;

    @Column(name = "total_price")
    private Long totalPrice;

}
