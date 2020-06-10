package com.carwash.schedulewashsvc.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.schedulewashsvc.model.ScheduleWash;



public interface ScheduleWashRepo extends MongoRepository<ScheduleWash, String>{
	
	boolean existsByUserId(String userId);

	Optional<ScheduleWash> findByUserId(String id);


}
