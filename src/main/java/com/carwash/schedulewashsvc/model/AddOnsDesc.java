package com.carwash.schedulewashsvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addonsdesc")
public class AddOnsDesc {
@Id	
private String id;
	
	
	private String description;
	
	
	private String packageid;
	
	
	private double price;


	public AddOnsDesc() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AddOnsDesc(String id, String description, String packageid, double price) {
		super();
		this.id = id;
		this.description = description;
		this.packageid = packageid;
		this.price = price;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPackageid() {
		return packageid;
	}


	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "AddOnsDesc [id=" + id + ", description=" + description + ", packageid=" + packageid + ", price=" + price
				+ "]";
	}
	
	

}
