package com.carwash.schedulewashsvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "package")
public class Packages {

	public Packages() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private String id;
	private String packagename;
	private double price;

	public Packages(String id, String packagename, double price) {
		super();
		this.id = id;
		this.packagename = packagename;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPackagename() {
		return packagename;
	}

	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Package [id=" + id + ", packagename=" + packagename + ", price=" + price + "]";
	}

	

}
