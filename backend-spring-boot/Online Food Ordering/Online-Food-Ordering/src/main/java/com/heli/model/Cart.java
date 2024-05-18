package com.heli.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int id;

    @OneToOne // uni
    @JoinColumn(name = "customer_id")
    private User customer;

    @Column(name = "total")
    private Long total;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL) // bi
    private List<CartItem> item = new ArrayList<>();
}
