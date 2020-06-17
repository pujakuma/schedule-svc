package com.carwash.schedulewashsvc.model;

import java.time.LocalDate;

public class PromoPutRequest {
	private String promoName;
	private Integer discountPercentage;
	private Float minimumAmount;
	private Float maximumAmount;
	private String updatedby;
	private LocalDate updatedDate;
	public String getPromoName() {
		return promoName;
	}
	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}
	public Integer getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public Float getMinimumAmount() {
		return minimumAmount;
	}
	public void setMinimumAmount(Float minimumAmount) {
		this.minimumAmount = minimumAmount;
	}
	public Float getMaximumAmount() {
		return maximumAmount;
	}
	public void setMaximumAmount(Float maximumAmount) {
		this.maximumAmount = maximumAmount;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
}
