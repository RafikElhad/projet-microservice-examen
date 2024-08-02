package com.groupeisi.driver_service.controller;

import com.groupeisi.driver_service.model.Driver;
import com.groupeisi.driver_service.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @GetMapping("/{id}")
    public Driver fetchDriverById(@PathVariable String id){
        return driverService.fetchDriverById(id);
    }
    @GetMapping
    public ResponseEntity<?> fetchDrivers(){
        return driverService.fetchDrivers();
    }
    @PostMapping
    public ResponseEntity<?> createDriver(@RequestBody Driver driver){
        return driverService.createDriver(driver);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDriver(@PathVariable String id, @RequestBody Driver driver) {
        return driverService.updateDriver(id, driver);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable String id) {
        return driverService.deleteDriver(id);
    }

}
