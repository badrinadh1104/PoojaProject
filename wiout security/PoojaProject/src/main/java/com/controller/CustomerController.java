package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;
import com.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("Customer")
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	
	
	@PostMapping(value = "RegisterNewCustomer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.AddCustomer(customer);
	}
	
	@GetMapping(value = "CustomerbyId/{id}")
	public Customer findCustomerById(@PathVariable("id") int id) {
		return customerService.FindbyId(id);
	}

}
