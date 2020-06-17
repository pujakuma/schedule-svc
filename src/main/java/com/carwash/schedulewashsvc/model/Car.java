package com.carwash.schedulewashsvc.model;

import java.io.InputStream;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public class Car {
	

	@Id
	private String id;
	
	private String name;
	
	private String model;
	
	private String description;
	
	private Integer year;
	
	private InputStream  image;
	
	
	

	public Car(String id, String name, String model, String description, Integer year, InputStream image) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.description = description;
		this.year = year;
		this.image = image;
	}
	public Car(String model) {
        super();
        this.model = model;
    }

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream inputStream) {
		this.image = inputStream;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getModel() {
		return model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", model=" + model + ", description=" + description + ", year="
				+ year + ", image=" + image + "]";
	}
	
}
