package com.carwash.schedulewashsvc.payload.resquest;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

public class SchedulePutRequest {
	
	
	
	private String carId;
	private Date completionDate;
	private String washLocation;
	
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public Date getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
	public String getWashLocation() {
		return washLocation;
	}
	public void setWashLocation(String washLocation) {
		this.washLocation = washLocation;
	}


	
	

}
