package com.carwash.schedulewashsvc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.schedulewashsvc.model.Car;
import com.carwash.schedulewashsvc.model.ScheduleWash;
import com.carwash.schedulewashsvc.payload.response.MessageResponse;
import com.carwash.schedulewashsvc.payload.resquest.SchedulePutRequest;
import com.carwash.schedulewashsvc.repository.CarMongoRepository;




@RestController
@RequestMapping("/api")
public class CarController {

	@Autowired
	CarMongoRepository carRepository;
	

	
		
	@PostMapping("/addcar")
	public ResponseEntity<MessageResponse> addCar(Car car) {
		 try {
		carRepository.save(car);
		String message="successfully created car details";
		return new ResponseEntity<>( new MessageResponse(message),HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
	}
	@GetMapping("/getcar/{id}")
	  public ResponseEntity<Car> getCarById(@PathVariable("id") String id) {
		 
		  Optional<Car> response = carRepository.findById(id);
		  Car car= response.get();
		 
	    if (response.isPresent()) {
	      return new ResponseEntity<>(response.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @DeleteMapping("/deleteCarById/{id}")
	  public ResponseEntity<MessageResponse> deleteCarById(@PathVariable("id") String id) {
	    try {
	    	//UserProfile response =profileService.deleteProfile(id);
	    	Optional<Car> response = carRepository.findById(id);
	    	
	    	carRepository.deleteById(id);
	    	
	    	//String message= id + "successfully deactivated";
	    	
	    	String message="successfully deactivated";
	      return new ResponseEntity<>( new MessageResponse(message),HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  @PutMapping("/updateCarDetails/{id}")
	  public ResponseEntity<Car> updateCarDetails(@PathVariable("id") String id, @RequestBody Car request) {
	    Optional<Car> response = carRepository.findById(id);

	    if (response.isPresent()) {
	    	Car scheduleWash = response.get();
	    	scheduleWash.setModel(request.getModel());
	    	scheduleWash.setYear(request.getYear());
	    	scheduleWash.setDescription(request.getDescription());
	    	
	      return new ResponseEntity<>(carRepository.save(scheduleWash), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	
	}
