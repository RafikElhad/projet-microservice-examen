package com.groupeisi.voyage_service.controller;

import com.groupeisi.voyage_service.model.Voyage;
import com.groupeisi.voyage_service.service.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/voyage")
public class VoyageController {

    @Autowired
    private VoyageService voyageService;
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchVoyageById(@PathVariable String id){
        return voyageService.fetchVoyageById(id);
    }
    @GetMapping
    public ResponseEntity<?> fetchVoyages(){
        return voyageService.fetchVoyages();
    }
    @PostMapping
    public ResponseEntity<?> createVoyage(@RequestBody Voyage voyage){
        return voyageService.createVoyage(voyage);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateVoyage(@PathVariable String id, @RequestBody Voyage voyage) {
        return voyageService.updateVoyage(id, voyage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVoyage(@PathVariable String id) {
        return voyageService.deleteVoyage(id);
    }
}
