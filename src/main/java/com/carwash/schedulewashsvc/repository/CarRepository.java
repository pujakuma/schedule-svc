package com.carwash.schedulewashsvc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.schedulewashsvc.model.Car;



public interface CarRepository extends MongoRepository<Car, String>{}