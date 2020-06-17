package com.carwash.schedulewashsvc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.schedulewashsvc.model.AddOns;


public interface AddOnRepo extends MongoRepository<AddOns, String>{

}
