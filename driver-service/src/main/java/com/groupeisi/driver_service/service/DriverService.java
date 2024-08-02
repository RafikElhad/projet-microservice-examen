package com.groupeisi.driver_service.service;

import com.groupeisi.driver_service.model.Driver;
import com.groupeisi.driver_service.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

   /* @Autowired
    private RestTemplate restTemplate;

    */

    public ResponseEntity<?> createDriver(Driver driver){
        try{
            return new ResponseEntity<Driver>(driverRepository.save(driver), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Driver fetchDriverById(String id){
        return driverRepository.findById(id).orElse(null);
    }
   /* public ResponseEntity<?> fetchDriverById(String id){
        Optional<Driver> driver =  driverRepository.findById(id);
        if(driver.isPresent()){
            Camion camion = restTemplate.getForObject("http://CAMION-SERVICE/camion/" + driver.get().getCamionId(), Camion.class);
            DriverResponse driverResponse = new DriverResponse(
                    driver.get().getId(),
                    driver.get().getName(),
                    driver.get().getGender(),
                    driver.get().getDrivingLicenceNumber(),
                    driver.get().getLicenceCategorie(),
                    camion
            );
            return new ResponseEntity<>(driverResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Driver Found",HttpStatus.NOT_FOUND);
        }
    }

    */



    public ResponseEntity<?> fetchDrivers(){
        List<Driver> drivers = driverRepository.findAll();
        if(drivers.size() > 0){
            return new ResponseEntity<List<Driver>>(drivers, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Drivers",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> updateDriver(String id, Driver driverDetails) {
        Optional<Driver> driverOptional = driverRepository.findById(id);
        if (driverOptional.isPresent()) {
            Driver driver = driverOptional.get();
            driver.setName(driverDetails.getName());
            driver.setGender(driverDetails.getGender());
            driver.setDrivingLicenceNumber(driverDetails.getDrivingLicenceNumber());
            driver.setLicenceCategorie(driverDetails.getLicenceCategorie());
            //driver.setCamionId(driverDetails.getCamionId());

            return new ResponseEntity<Driver>(driverRepository.save(driver), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Driver not found", HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> deleteDriver(String id) {
        try {
            driverRepository.deleteById(id);
            return new ResponseEntity<>("Driver deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
