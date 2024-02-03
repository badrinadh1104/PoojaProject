package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dto.ConfirmAppointmentDTO;
import com.model.Appointment;
import com.model.Priest;
import com.repo.AppointmentRepo;
import com.repo.PriestRepo;

@Service
public class PriestService {
	@Autowired
	private PriestRepo priestRepo;
	
	@Autowired
	private AppointmentRepo appointmentRepo;
	
	public Priest addPriest(Priest priest) {
		return priestRepo.save(priest);
	}
	
	public Appointment ConfirmAppointment(ConfirmAppointmentDTO appointmentDTO) throws Exception {
		Appointment appointment = appointmentRepo.findById(appointmentDTO.getAppointment_id()).get();
		Priest priest = priestRepo.findById(appointmentDTO.getPriest_id()).get();
		if(appointment != null) {
			if(priest != null) {
				appointment.setConfirmation(true);
				appointment.setPriest_id(priest);
				appointmentRepo.save(appointment);
				return appointment;
			}else {
				throw new Exception("Priest Not Found");
			}
		}else {
			throw new Exception("Appointment Not Found");
		}
	}
	
	public Priest PriestById( int id) {
		return priestRepo.findById(id).get();
	}
	
	
	
	

}