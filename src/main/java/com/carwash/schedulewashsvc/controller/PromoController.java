package com.carwash.schedulewashsvc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.schedulewashsvc.model.PromoCode;
import com.carwash.schedulewashsvc.model.PromoPutRequest;
import com.carwash.schedulewashsvc.payload.response.MessageResponse;
import com.carwash.schedulewashsvc.service.PromoCodeService;

@RestController
@RequestMapping("/api")
public class PromoController {
	@Autowired
	private PromoCodeService promoService;

	@PostMapping("/savePromoCodeDetails")
	public PromoCode savePromoCodeDetails(@RequestBody PromoCode promo) {
		return promoService.savePromoCodeDetails(promo);
	}
	
	@GetMapping("/getPromocodesByName/{promoname}")
	public Optional<PromoCode> getPromo(@PathVariable("promoname") String promoname){
		return promoService.getPromoDetail(promoname);
	}
	
	
	@PutMapping("/updatePromoCodeDetails/{id}")
	public ResponseEntity<MessageResponse> updatePromoCodeDetails(@PathVariable("id") String id,@RequestBody PromoPutRequest request) {
		
		
		MessageResponse message =promoService.updatePromoCodeDetails(id,request);
		
		/*String response=id + "" +"successfully updated";
		 return new ResponseEntity<>(new MessageResponse(response),HttpStatus.OK);*/
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
}
