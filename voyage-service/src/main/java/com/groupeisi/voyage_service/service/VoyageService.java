package com.groupeisi.voyage_service.service;

import com.groupeisi.voyage_service.dto.Camion;
import com.groupeisi.voyage_service.dto.Driver;
import com.groupeisi.voyage_service.dto.VoyageResponse;
import com.groupeisi.voyage_service.model.Voyage;
import com.groupeisi.voyage_service.repository.VoyageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class VoyageService {

    @Autowired
    private VoyageRepository voyageRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> createVoyage(Voyage voyage){
        try{
            return new ResponseEntity<Voyage>(voyageRepository.save(voyage), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchVoyageById(String id){
        Optional<Voyage> voyage =  voyageRepository.findById(id);
        if(voyage.isPresent()){
            Camion camion = restTemplate.getForObject("http://CAMION-SERVICE/camion/" + voyage.get().getCamionId(), Camion.class);
            Driver driver = restTemplate.getForObject("http://DRIVER-SERVICE/driver/" + voyage.get().getDriverId(), Driver.class);
            VoyageResponse voyageResponse = new VoyageResponse(
                    voyage.get().getId(),
                    voyage.get().getStartPoint(),
                    voyage.get().getDestination(),
                    voyage.get().getStatus(),
                    camion,
                    driver
            );
            return new ResponseEntity<>(voyageResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Driver Found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchVoyages(){
        List<Voyage> voyages = voyageRepository.findAll();
        if(voyages.size() > 0){
            return new ResponseEntity<List<Voyage>>(voyages, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Voyages",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> updateVoyage(String id, Voyage voyageDetails) {
        Optional<Voyage> voyageOptional = voyageRepository.findById(id);
        if (voyageOptional.isPresent()) {
            Voyage voyage = voyageOptional.get();
            voyage.setStartPoint(voyageDetails.getStartPoint());
            voyage.setDestination(voyageDetails.getDestination());
            voyage.setStatus(voyageDetails.getStatus());
            voyage.setCamionId(voyageDetails.getCamionId());
            voyage.setDriverId(voyageDetails.getDriverId());

            return new ResponseEntity<Voyage>(voyageRepository.save(voyage), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Voyage not found", HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> deleteVoyage(String id) {
        try {
            voyageRepository.deleteById(id);
            return new ResponseEntity<>("Voyage deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
