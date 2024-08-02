package com.groupeisi.voyage_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "voyages")
public class Voyage {
    @Id
    private String id;
    private String startPoint;
    private String destination;
    private String status;
    private Integer camionId;
    private String driverId;
}
