package com.carwash.schedulewashsvc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.carwash.schedulewashsvc.model.Car;



public interface CarMongoRepository extends MongoRepository<Car, String>{}