package com.carwash.schedulewashsvc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.schedulewashsvc.model.AddOnsDesc;

public interface AddOnDescRepo extends MongoRepository<AddOnsDesc, String> {

}
