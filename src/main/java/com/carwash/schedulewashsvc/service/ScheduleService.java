package com.carwash.schedulewashsvc.service;

import com.carwash.schedulewashsvc.model.ScheduleWash;


public interface ScheduleService {
	
	public ScheduleWash createUserProfile(ScheduleWash request);

	public ScheduleWash getUserInfoById(String id);

	public ScheduleWash deleteProfile(String id);
}
