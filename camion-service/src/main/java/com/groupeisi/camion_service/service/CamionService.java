package com.groupeisi.camion_service.service;

import com.groupeisi.camion_service.entity.Camion;
import com.groupeisi.camion_service.repository.CamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CamionService {
    @Autowired
    private CamionRepository camionRepository;

    public Camion addCamion(Camion camion){
        return camionRepository.save(camion);
    }
    public List<Camion> fetchCamions(){
        return camionRepository.findAll();
    }
    public Camion fetchCamionById(int id){
        return camionRepository.findById(id).orElse(null);
    }
    public Camion updateCamion(int id, Camion updatedCamion) {
        return camionRepository.findById(id).map(camion -> {
            camion.setBrand(updatedCamion.getBrand());
            camion.setRegistrationNumber(updatedCamion.getRegistrationNumber());
            camion.setLoadCapacity(updatedCamion.getLoadCapacity());
            camion.setFuelType(updatedCamion.getFuelType());
            return camionRepository.save(camion);
        }).orElse(null);
    }

    public void deleteCamion(int id) {
        camionRepository.deleteById(id);
    }
}
