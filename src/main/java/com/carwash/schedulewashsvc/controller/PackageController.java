package com.carwash.schedulewashsvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.schedulewashsvc.model.AddOnsDesc;
import com.carwash.schedulewashsvc.model.Packages;
import com.carwash.schedulewashsvc.repository.AddOnDescRepo;
import com.carwash.schedulewashsvc.repository.PackageRepo;

@RestController
@RequestMapping("/api")
public class PackageController {
	
	
	@Autowired
	private PackageRepo repository;
	
	@Autowired
	private AddOnDescRepo repo;
	
	@GetMapping("/getPackageDetails")
	public List<Packages> getPackageDetails() {
		return repository.findAll();
	}
	
	
	@GetMapping("/getPackageDetails/{id}")
	  public ResponseEntity<Packages> getPackageDetailsById(@PathVariable("id") String id) {
		 
		  Optional<Packages> response = repository.findById(id);
		 
	    if (response.isPresent()){
	      return new ResponseEntity<>(response.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@GetMapping("/getAddOnDesc")
	public List<AddOnsDesc> getAddOnDesc() {
		return repo.findAll();
	}
	/*@GetMapping("/getAddOnDesc/{packageid}")
	  public List<AddOnDescription> getAddOnDescId(@PathVariable("packageid") Integer id) {
		//ResponseEntity entity="";
		  Optional<AddOnDescription> response = packageRepository.findByPackageId(id);
		 
	    if (response.isPresent()){
	      return 
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }*/

}
