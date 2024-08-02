package com.groupeisi.voyage_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VoyageResponse {

    private String id;
    private String startPoint;
    private String destination;
    private String status;
    private Camion camion;
    private Driver driver;
}
