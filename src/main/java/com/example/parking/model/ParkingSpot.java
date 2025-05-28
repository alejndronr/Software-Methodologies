package com.example.parking.model;

import jakarta.persistence.*;

@Entity
public class ParkingSpot {
    @Id @GeneratedValue
    private Long id;
    private String location;
    private Boolean isAvailable;
    private Double pricePerHour;

    // Getters and setters omitted for brevity
}
