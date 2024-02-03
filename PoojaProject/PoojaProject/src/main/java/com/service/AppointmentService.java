package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dto.AppointmentBookingDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.model.Appointment;
import com.model.Customer;
import com.repo.AppointmentRepo;
import com.repo.CustomerRepo;

@Service
public class AppointmentService {
	
	@Autowired
	public AppointmentRepo appointmentRepo;
	
	@Autowired
	public CustomerRepo customerRepo;
	
	
	public Appointment BookAppointment(@RequestBody AppointmentBookingDTO bookingDTO) throws Exception {
		Customer customer = customerRepo.findById(bookingDTO.getCustomerid()).get();
		if(customer != null) {
			Appointment appointment = new Appointment(bookingDTO.getOccasion(), bookingDTO.getDate(), false, false);
			customer.addAppointment(appointment);
			appointment.setCustomer_id(customer);
			appointmentRepo.save(appointment);
			return appointment;
		}else {
			throw new Exception("Customer NotFound");
		}
	}
	
	public List<Appointment> getAllAppointments(){
		return appointmentRepo.findAll();
	}
}