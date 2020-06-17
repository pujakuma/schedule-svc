package com.carwash.schedulewashsvc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.schedulewashsvc.model.PromoCode;
import com.carwash.schedulewashsvc.model.PromoPutRequest;
import com.carwash.schedulewashsvc.payload.response.MessageResponse;
import com.carwash.schedulewashsvc.repository.PromoRepo;

@Service
public class PromoCodeServiceImpl implements PromoCodeService {
	@Autowired
	private PromoRepo promoRepository;
	
	
	@Override
	public PromoCode savePromoCodeDetails(PromoCode promo) {
		/*LocalDate ldObj = LocalDate.now();
		promo.setCreatedDate(ldObj);
		promo.setUpdatedDate(ldObj);*/
		return promoRepository.save(promo);
	}


	@Override
	public Optional<PromoCode> getPromoDetail(String promoname) {
		return promoRepository.findByPromoName(promoname);
	}


	@Override
	public MessageResponse updatePromoCodeDetails(String id,PromoPutRequest request) {
		MessageResponse message=new MessageResponse(" Successfully updated");
		Optional<PromoCode> response = promoRepository.findById(id);
	    if (response.isPresent()) {
	    	PromoCode promo = response.get();
	    	promo.setPromoName(request.getPromoName());
	    	promo.setMinimumAmount(request.getMinimumAmount());
	    	promoRepository.save(promo);	
	    }
	    else new MessageResponse("id not found");
		return message;
	}
}
