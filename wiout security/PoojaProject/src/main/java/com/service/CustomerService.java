package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dto.AppointmentBookingDTO;
import com.model.Appointment;
import com.model.Customer;
import com.repo.AppointmentRepo;
import com.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	public CustomerRepo customerRepo;
	
	@Autowired
	private AppointmentRepo appointmentRepo;
	
	public Customer AddCustomer(Customer customer) {
		return customerRepo.save(customer);
		
	}
	
	
	public Customer FindbyId(int id) {
		return customerRepo.findById(id).get();
	}
	

}
