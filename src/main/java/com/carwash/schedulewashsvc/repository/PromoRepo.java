package com.carwash.schedulewashsvc.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.schedulewashsvc.model.PromoCode;

public interface PromoRepo extends MongoRepository<PromoCode, String> {
	
Optional<PromoCode> findByPromoName(String promoname);
}
