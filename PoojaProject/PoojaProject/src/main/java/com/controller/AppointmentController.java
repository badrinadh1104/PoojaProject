package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AppointmentBookingDTO;
import com.model.Appointment;
import com.service.AppointmentService;

@RestController
@CrossOrigin
@RequestMapping("Appoinment")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	
	@PostMapping(value = "bookCustomerAppointment")
	public Appointment bookCustomerAppointment(@RequestBody AppointmentBookingDTO appointmentBookingDTO) throws Exception {
		return appointmentService.BookAppointment(appointmentBookingDTO);
	}
	
	@GetMapping(value = "getAllAppointments")
	public List<Appointment> getAllAppointments(){
		return appointmentService.getAllAppointments();
	}

}
