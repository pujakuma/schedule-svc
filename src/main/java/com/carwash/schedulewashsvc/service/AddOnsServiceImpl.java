package com.carwash.schedulewashsvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.schedulewashsvc.model.AddOns;
import com.carwash.schedulewashsvc.repository.AddOnRepo;

@Service
public class AddOnsServiceImpl implements AddOnsService {

	@Autowired
	private AddOnRepo addOnRepository; 
	@Override
	public AddOns saveaddons(AddOns request) {
		// verifyUserAccess(userId);
		
				//String status="PENDING";
				//request.setWorkStatus(status);
				
				return addOnRepository.save(request);
	}
	
}
