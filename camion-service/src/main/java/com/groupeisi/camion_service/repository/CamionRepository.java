package com.groupeisi.camion_service.repository;

import com.groupeisi.camion_service.entity.Camion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamionRepository extends JpaRepository<Camion,Integer> {
}
