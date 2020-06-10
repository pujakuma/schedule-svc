package com.carwash.schedulewashsvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.schedulewashsvc.model.ScheduleWash;
import com.carwash.schedulewashsvc.repository.ScheduleWashRepo;


@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private  ScheduleWashRepo washrepo;

	@Override
	public ScheduleWash createUserProfile(ScheduleWash request) {
		// verifyUserAccess(userId);
		ScheduleWash user=new ScheduleWash();
				String status="PENDING";
				request.setWorkStatus(status);
				
				return washrepo.save(request);
	}

	@Override
	public ScheduleWash getUserInfoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduleWash deleteProfile(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
