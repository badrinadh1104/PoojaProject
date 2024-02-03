package com.dto;

public class ConfirmAppointmentDTO {
	int priest_id;
	int appointment_id;
	public int getPriest_id() {
		return priest_id;
	}
	public void setPriest_id(int priest_id) {
		this.priest_id = priest_id;
	}
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public ConfirmAppointmentDTO(int priest_id, int appointment_id) {
		super();
		this.priest_id = priest_id;
		this.appointment_id = appointment_id;
	}
	

}
