package com.carwash.schedulewashsvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carwash.schedulewashsvc.model.ScheduleWash;
import com.carwash.schedulewashsvc.payload.response.MessageResponse;
import com.carwash.schedulewashsvc.repository.ScheduleWashRepo;

public class WasherController {
	@Autowired
	private ScheduleWashRepo scheduleWashRepo;

	@PutMapping("/acceptorreject/{scheduleId}")
	public ResponseEntity<MessageResponse> updateSchedule(@PathVariable("scheduleId") String id,
			@RequestParam("status") String status) {
		Optional<ScheduleWash> response = scheduleWashRepo.findById(id);

		String message="";
		String workstatus="";
		if (response.isPresent()) {
			ScheduleWash scheduleWash = response.get();
			scheduleWash.setWorkStatus(status);
			scheduleWashRepo.save(scheduleWash);
			workstatus=scheduleWash.getWorkStatus();
			if(workstatus.equalsIgnoreCase("Accept")) {
			message="Wash Accepted by washer";
			}else {
				message="Wash Rejected by washer";
			}
			
			return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getscheduledwash")
	public List<ScheduleWash> getscheduledwash() {
		return scheduleWashRepo.findAll();
	}

	@PutMapping("/washcomplete/{scheduleId}")
	public ResponseEntity<MessageResponse> washcomplete(@PathVariable("scheduleId") String id,
			@RequestParam("status") String status) {
		Optional<ScheduleWash> response = scheduleWashRepo.findById(id);

		String message="";
		if (response.isPresent()) {
			ScheduleWash scheduleWash = response.get();
			scheduleWash.setWorkStatus(status);
			scheduleWashRepo.save(scheduleWash);
			message="Wash Completed by washer";

			return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
