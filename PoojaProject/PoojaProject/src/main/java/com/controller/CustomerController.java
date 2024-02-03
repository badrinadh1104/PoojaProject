package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.JwtUtil;
import com.dto.AuthenticationRequest;
import com.dto.AuthenticationResponse;
import com.model.Customer;
import com.repo.CustomerRepo;
import com.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomerRepo customerRepo;
	
	@PostMapping(value = "Authenticate")
	public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		} catch (DisabledException e) {
			// TODO: handle exception
			throw new Exception("User_disabled", e);
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("Invalid_Credentials", e);
		}
		
		UserDetails userDetails = customerService.loadUserByUsername(authenticationRequest.getUsername());
		Customer user = customerRepo.findByEmail(authenticationRequest.getUsername());
		String token = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(token,user));
	}
	@PostMapping(value = "RegisterNewCustomer",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer saveCustomer(@RequestBody Customer customer) throws Exception {
		return customerService.AddCustomer(customer);
	}
	
	@GetMapping(value = "CustomerbyId/{id}")
	public Customer findCustomerById(@PathVariable("id") int id) {
		return customerService.FindbyId(id);
	}

}
