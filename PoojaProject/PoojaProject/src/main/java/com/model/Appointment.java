package com.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String occasion;
	private LocalDate date;
	private boolean confirmation;
	private boolean payment;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
//	@JsonBackReference
	@JsonIgnore
	private Customer customer_id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "priest_id")
//	@JsonBackReference
	@JsonIgnore
	private Priest priest_id;

	

	

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment( String occasion, LocalDate date, boolean confirmation, boolean payment) {
		super();
		
		this.occasion = occasion;
		this.date = date;
		this.confirmation = confirmation;
		this.payment = payment;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	public Customer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}

	public Priest getPriest_id() {
		return priest_id;
	}

	public void setPriest_id(Priest priest_id) {
		this.priest_id = priest_id;
	}

	
	
	
	
	

}
