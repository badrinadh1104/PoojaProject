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
public class Priest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String priestFullName;
	private String phone;
	private String email;
	private String password;
	private int experience;
	private String qualifications;
	private String address;
	private String city;
	private String province;
	private String Country;
	private boolean available;
	@OneToMany(cascade = CascadeType.ALL,fetch =  FetchType.LAZY,mappedBy = "priest_id")
//	@JsonManagedReference
	private List<Appointment> appointments;
	

	
	public Priest() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Priest(int id, String priestFullName, String phone, String email, String password, int experience,
			String qualifications, String address, String city, String province, String country, boolean available,
			List<Appointment> appointments) {
		super();
		this.id = id;
		this.priestFullName = priestFullName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.experience = experience;
		this.qualifications = qualifications;
		this.address = address;
		this.city = city;
		this.province = province;
		Country = country;
		this.available = available;
		this.appointments = appointments;
	}
	
	
	
	public String getPriestFullName() {
		return priestFullName;
	}
	public void setPriestFullName(String priestFullName) {
		this.priestFullName = priestFullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
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
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
	public void addAppointment(Appointment appointment) {
		if(appointments == null) {
			appointments = new ArrayList<Appointment>();
		}
		appointments.add(appointment);
	}
	
	
	

}
