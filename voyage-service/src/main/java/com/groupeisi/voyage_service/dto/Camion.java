package com.groupeisi.voyage_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Camion {

    private int id;
    private String brand;
    private String registrationNumber;
    private String loadCapacity;
    private String fuelType;
}
