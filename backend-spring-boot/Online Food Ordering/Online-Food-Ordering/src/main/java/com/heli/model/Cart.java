package com.heli.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL) // uni
    @JoinColumn(name = "customer_id")
    private User customer;

    @Column(name = "total")
    private Long total;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL) // bi
    private List<CartItem> item = new ArrayList<>();
}
