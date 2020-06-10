package com.carwash.schedulewashsvc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.schedulewashsvc.model.ScheduleWash;
import com.carwash.schedulewashsvc.payload.response.MessageResponse;
import com.carwash.schedulewashsvc.payload.resquest.SchedulePutRequest;
import com.carwash.schedulewashsvc.repository.ScheduleWashRepo;
import com.carwash.schedulewashsvc.service.ScheduleService;



@RestController
@RequestMapping("/api")
public class ScheduleController {
	
	 @Autowired
	  private ScheduleWashRepo respository;
	 @Autowired
	  private ScheduleService washservice;
	  
	
	@PostMapping("/saveschedule")
	  public ResponseEntity<MessageResponse> createschedule(@RequestBody ScheduleWash request) {
	    try {
	    	
	    	/*if (respository.existsByUserId(request.getUserId())) {
	    		return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Error: User is already created !"));
						
	    	}*/
	    	ScheduleWash response =washservice.createUserProfile(request);
	    	String id =response.getScheduleId();
	    	String message=id + "successfully created";
	    	return new ResponseEntity<>( new MessageResponse(message),HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }

	  @GetMapping("/getschedule/{userid}")
	  public ResponseEntity<ScheduleWash> getScheduleById(@PathVariable("userid") String id) {
		 
		  Optional<ScheduleWash> response = respository.findByUserId(id);
		  ScheduleWash userprofile= response.get();
		 
	    if (response.isPresent()) {
	      return new ResponseEntity<>(response.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @DeleteMapping("/deleteschedule/{scheduleId}")
	  public ResponseEntity<MessageResponse> deleteSchedule(@PathVariable("scheduleId") String id) {
	    try {
	    	//UserProfile response =profileService.deleteProfile(id);
	    	Optional<ScheduleWash> response = respository.findById(id);
	    	
	    	respository.deleteById(id);
	    	
	    	//String message= id + "successfully deactivated";
	    	
	    	String message="successfully deactivated";
	      return new ResponseEntity<>( new MessageResponse(message),HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  @PutMapping("/updateschedule/{scheduleId}")
	  public ResponseEntity<ScheduleWash> updateSchedule(@PathVariable("scheduleId") String id, @RequestBody SchedulePutRequest request) {
	    Optional<ScheduleWash> response = respository.findById(id);

	    if (response.isPresent()) {
	    	ScheduleWash scheduleWash = response.get();
	    	scheduleWash.setCarId(request.getCarId());
	    	scheduleWash.setCompletionDate(request.getCompletionDate());
	    	scheduleWash.setWashLocation(request.getWashLocation());
	    	
	      return new ResponseEntity<>(respository.save(scheduleWash), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	
}


