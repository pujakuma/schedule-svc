package com.carwash.schedulewashsvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addons")
public class AddOns {
	@Id
	private String id;

	private String descriptionid;

	private String Scheduleid;

	public AddOns() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddOns(String id, String descriptionid, String scheduleid) {
		super();
		this.id = id;
		this.descriptionid = descriptionid;
		Scheduleid = scheduleid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescriptionid() {
		return descriptionid;
	}

	public void setDescriptionid(String descriptionid) {
		this.descriptionid = descriptionid;
	}

	public String getScheduleid() {
		return Scheduleid;
	}

	public void setScheduleid(String scheduleid) {
		Scheduleid = scheduleid;
	}

	@Override
	public String toString() {
		return "AddOns [id=" + id + ", descriptionid=" + descriptionid + ", Scheduleid=" + Scheduleid + "]";
	}

}
