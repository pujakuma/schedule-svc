package com.carwash.schedulewashsvc.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "schedule")
public class ScheduleWash {
	

		public ScheduleWash() {
		super();
		// TODO Auto-generated constructor stub
	}
		@Id
		private String scheduleId;
		private String userId;
		private String carId;
		private String workStatus;
		//private String washPackageId;
		@CreatedDate
		private Date date;
		
		private Date completionDate;
		private String washLocation;
		
		public ScheduleWash(String scheduleId, String userId, String carId, String workStatus, Date date,
				Date completionDate, String washLocation) {
			super();
			this.scheduleId = scheduleId;
			this.userId = userId;
			this.carId = carId;
			this.workStatus = workStatus;
			this.date = date;
			this.completionDate = completionDate;
			this.washLocation = washLocation;
		}
		public String getScheduleId() {
			return scheduleId;
		}
		public void setScheduleId(String scheduleId) {
			this.scheduleId = scheduleId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getCarId() {
			return carId;
		}
		public void setCarId(String carId) {
			this.carId = carId;
		}
		public String getWorkStatus() {
			return workStatus;
		}
		public void setWorkStatus(String workStatus) {
			this.workStatus = workStatus;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
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
		@Override
		public String toString() {
			return "ScheduleWash [scheduleId=" + scheduleId + ", userId=" + userId + ", carId=" + carId
					+ ", workStatus=" + workStatus + ", date=" + date + ", completionDate=" + completionDate
					+ ", washLocation=" + washLocation + "]";
		}
	
		

	 
	

}
