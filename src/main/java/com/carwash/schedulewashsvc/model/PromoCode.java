package com.carwash.schedulewashsvc.model;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="promocode")
public class PromoCode {
@Id	
private String id;
	
	
	private String promoName;
	
	
	private Integer discountPercentage;
	
	
	private Float minimumAmount;
	
	
	private Float maximumAmount;
	
	
	private String status;
	
	@CreatedBy()
	private String createdby;
	
	@CreatedDate
	private LocalDate createdDate;
	
	@LastModifiedBy
	private String updatedby;
	
	@LastModifiedDate
	private LocalDate updatedDate;

	public PromoCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PromoCode(String id, String promoName, Integer discountPercentage, Float minimumAmount, Float maximumAmount,
			String status, String createdby, LocalDate createdDate, String updatedby, LocalDate updatedDate) {
		super();
		this.id = id;
		this.promoName = promoName;
		this.discountPercentage = discountPercentage;
		this.minimumAmount = minimumAmount;
		this.maximumAmount = maximumAmount;
		this.status = status;
		this.createdby = createdby;
		this.createdDate = createdDate;
		this.updatedby = updatedby;
		this.updatedDate = updatedDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
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

	@Override
	public String toString() {
		return "PromoCode [id=" + id + ", promoName=" + promoName + ", discountPercentage=" + discountPercentage
				+ ", minimumAmount=" + minimumAmount + ", maximumAmount=" + maximumAmount + ", status=" + status
				+ ", createdby=" + createdby + ", createdDate=" + createdDate + ", updatedby=" + updatedby
				+ ", updatedDate=" + updatedDate + "]";
	}
	

}
