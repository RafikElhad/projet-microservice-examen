package com.groupeisi.driver_service.repository;

import com.groupeisi.driver_service.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends MongoRepository<Driver, String>{
}
