package com.heli.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {

    @Id
    private int id;

    @ManyToOne
    private User customer;

}
