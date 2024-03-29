package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ConfirmAppointmentDTO;
import com.model.Appointment;
import com.model.Priest;
import com.service.PriestService;

@RestController
@RequestMapping("Priest")
@CrossOrigin
public class PriestController {
	
	@Autowired
	private PriestService priestService;
	
	@PostMapping(value = "RegisterPriest", consumes = "application/json", produces = "application/json")
	public Priest addPriest(@RequestBody Priest priest) {
		return priestService.addPriest(priest);
	}
	
	@PutMapping(value = "ConfirmAppointment")
	public Appointment ConfirmAppointment(@RequestBody ConfirmAppointmentDTO appointmentDTO) throws Exception {
		return priestService.ConfirmAppointment(appointmentDTO);
	}
	
	@GetMapping(value = "PriestByID/{id}")
	public Priest PriestByid(@PathVariable("id") int id) {
		return priestService.PriestById(id);
	}

}
