package com.carwash.schedulewashsvc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.schedulewashsvc.model.Packages;





public interface PackageRepo extends MongoRepository<Packages, String>{
	//Optional<Package> findByPackageName(String promoname);

}
