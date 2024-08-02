package com.groupeisi.driver_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverResponse {

    private String id;
    private String name;
    private String gender;
    private String drivingLicenceNumber;
    private String licenceCategorie;
    //private Camion camion;
}
