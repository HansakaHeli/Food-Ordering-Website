package com.heli.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.apache.catalina.LifecycleState;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @ManyToOne // bi
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne // bi
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    @Column(name = "total_amount")
    private Long totalAmount;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_date")
    private Date createdAt;

    @ManyToOne // uni
    @JoinColumn(name = "address_id")
    private Address deliveryAddress;

    @OneToMany // uni
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    //private Payment payment;

    @Column(name = "total_item")
    private int totalItem;

    @Column(name = "total_price")
    private int totalPrice;

}
