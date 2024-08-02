package com.groupeisi.voyage_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    private String id;
    private String name;
    private String gender;
    private String drivingLicenceNumber;
    private String licenceCategorie;
}
