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

import com.carwash.schedulewashsvc.model.AddOns;
import com.carwash.schedulewashsvc.model.AddOnsPutRequest;
import com.carwash.schedulewashsvc.payload.response.MessageResponse;
import com.carwash.schedulewashsvc.repository.AddOnRepo;
import com.carwash.schedulewashsvc.service.AddOnsService;

@RestController
@RequestMapping("/api")
public class AddOnController {
	@Autowired
	private AddOnsService addOnService;
	
	@Autowired
	private AddOnRepo addOnRepository;

	@PostMapping("/saveaddons")
	public ResponseEntity<MessageResponse> saveaddons(@RequestBody AddOns request) {
		try {

			AddOns response = addOnService.saveaddons(request);
			String id = response.getId();
			String message = id + "" + " Successfully created ";
			return new ResponseEntity<>(new MessageResponse(message), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/getaddon/{id}")
	public ResponseEntity<AddOns> getaddon(@PathVariable("id") String id) {

		Optional<AddOns> response = addOnRepository.findById(id);
		//ScheduleWash userprofile = response.get();

		if (response.isPresent()) {
			return new ResponseEntity<>(response.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteaddon/{id}")
	public ResponseEntity<MessageResponse> deleteaddon(@PathVariable("id") String id) {
		try {
			// UserProfile response =profileService.deleteProfile(id);
			//Optional<AddOns> response = 
					addOnRepository.findById(id);

			addOnRepository.deleteById(id);

			// String message= id + "successfully deactivated";

			String message = "successfully deleted";
			return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/updateaddon/{id}")
  public ResponseEntity<AddOns> updateaddon(@PathVariable("id") String id, @RequestBody AddOnsPutRequest request) {
    Optional<AddOns> response = addOnRepository.findById(id);

    if (response.isPresent()) {
    	AddOns addon = response.get();
    	addon.setDescriptionid(request.getDescriptionid());
    	addon.setScheduleid(request.getScheduleid());
    	
    	
      return new ResponseEntity<>(addOnRepository.save(addon), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


}
