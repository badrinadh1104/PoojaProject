package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String fullName;
	public String password;
	public String email;
	public String phone;
	public String address;
	public String city;
	public String province;
	public String zipcode;
	public String country;
	public String role;
	
	@OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "customer_id")
//	@JsonManagedReference
	public List<Appointment> cappointments;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id,String fullName, String password, String email, String phone, String address, String city,
			String province, String zipcode, String country, List<Appointment> appointments,String role) {
		super();
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.province = province;
		this.zipcode = zipcode;
		this.country = country;
		this.cappointments = appointments;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public List<Appointment> getAppointments() {
		return cappointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.cappointments = appointments;
	}
	
	
	public void addAppointment(Appointment appointment) {
		if(cappointments == null) {
			cappointments = new ArrayList<Appointment>();
		}
		cappointments.add(appointment);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Appointment> getCappointments() {
		return cappointments;
	}

	public void setCappointments(List<Appointment> cappointments) {
		this.cappointments = cappointments;
	}
	
	
	
	
	

}
