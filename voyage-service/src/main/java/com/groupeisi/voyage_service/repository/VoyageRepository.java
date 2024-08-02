package com.groupeisi.voyage_service.repository;

import com.groupeisi.voyage_service.model.Voyage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoyageRepository extends MongoRepository<Voyage, String>{
}
