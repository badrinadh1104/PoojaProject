package com.dto;

import java.time.LocalDate;

public class AppointmentBookingDTO {
	
	public int customerid;
	private String occasion;
	private LocalDate date;
	private boolean confirmation;
	private boolean payment;
	public AppointmentBookingDTO(int customerid, String occasion, LocalDate date, boolean confirmation,
			boolean payment) {
		super();
		this.customerid = customerid;
		this.occasion = occasion;
		this.date = date;
		this.confirmation = confirmation;
		this.payment = payment;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getOccasion() {
		return occasion;
	}
	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isConfirmation() {
		return confirmation;
	}
	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}
	public boolean isPayment() {
		return payment;
	}
	public void setPayment(boolean payment) {
		this.payment = payment;
	}
	
	
	

}
