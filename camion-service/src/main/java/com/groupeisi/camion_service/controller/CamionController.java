package com.groupeisi.camion_service.controller;

import com.groupeisi.camion_service.entity.Camion;
import com.groupeisi.camion_service.service.CamionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RequestMapping(value = "/camion")
@RestController
public class CamionController {
    @Autowired
    private CamionService camionService;

    @PostMapping
    public Camion addCamion(@RequestBody Camion camion){
        return camionService.addCamion(camion);
    }
    @GetMapping
    public List<Camion> fetchCamions(){
        return  camionService.fetchCamions();
    }
    @GetMapping("/{id}")
    public Camion fetchCamionById(@PathVariable int id){
        return camionService.fetchCamionById(id);
    }
    @PutMapping("/{id}")
    public Camion updateCamion(@PathVariable int id, @RequestBody Camion camion) {
        return camionService.updateCamion(id, camion);
    }

    @DeleteMapping("/{id}")
    public void deleteCamion(@PathVariable int id) {
        camionService.deleteCamion(id);
    }
}
