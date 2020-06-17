package com.carwash.schedulewashsvc.service;

import java.util.Optional;

import com.carwash.schedulewashsvc.model.PromoCode;
import com.carwash.schedulewashsvc.model.PromoPutRequest;
import com.carwash.schedulewashsvc.payload.response.MessageResponse;

public interface PromoCodeService {
	PromoCode savePromoCodeDetails(PromoCode promo);

	Optional<PromoCode> getPromoDetail(String promoname);

	MessageResponse updatePromoCodeDetails(String id, PromoPutRequest request);
}
