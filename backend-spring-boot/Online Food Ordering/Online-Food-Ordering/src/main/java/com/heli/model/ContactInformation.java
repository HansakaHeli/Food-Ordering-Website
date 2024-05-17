package com.heli.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class ContactInformation {

    private String emil;
    private String mobile;
    private String twitter;
    private String instragram;


}

// Create getters and setters