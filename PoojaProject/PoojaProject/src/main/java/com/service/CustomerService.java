package com.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.model.Customer;
import com.repo.AppointmentRepo;
import com.repo.CustomerRepo;

@Service
public class CustomerService implements UserDetailsService {

	@Autowired
	public CustomerRepo customerRepo;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private AppointmentRepo appointmentRepo;
	
	
	
	public Customer AddCustomer(Customer customer) throws Exception {
		Customer c1 = customerRepo.findByEmail(customer.getEmail());
		if (c1 != null) {
			throw new Exception("User already Exist with " + customer.getEmail());
		} else {
			customer.setPassword(bcryptEncoder.encode(customer.getPassword()));
			return customerRepo.save(customer);
		}		
	}
	
	
	public Customer FindbyId(int id) {
		return customerRepo.findById(id).get();
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority> roles = null;
		Customer c = customerRepo.findByEmail(email);
		if (c != null) {
			roles = Arrays.asList(new SimpleGrantedAuthority(c.getRole()));
			return new User(c.getEmail(), c.getPassword(), roles);
		}
		throw new UsernameNotFoundException("User not Found With Username " + email);
	}
	

}
