package com.btl.dattiec.Models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "code")
	private String code;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToMany
	@JoinTable(
		   name = "lobby_service",
		   joinColumns = {
				 @JoinColumn(name = "invoice_id")
		   },
		   inverseJoinColumns = {
				 @JoinColumn(name = "lobby_id")
		   }
	)
	private List<Lobby> lobby = new ArrayList<>();

	@ManyToMany
	@JoinTable(
		   name = "invoice_service",
		   joinColumns = {
				 @JoinColumn(name = "invoice_id")
		   },
		   inverseJoinColumns = {
				 @JoinColumn(name = "service_id")
		   }
	)
	private List<Service> service = new ArrayList<>();

	@ManyToMany
	@JoinTable(
		   name = "invoice_food",
		   joinColumns = {
				 @JoinColumn(name = "invoice_id")
		   },
		   inverseJoinColumns = {
				 @JoinColumn(name = "food_id")
		   }
	)
	private List<Food> food = new ArrayList<>();

	@Column(name = "date_of_payment")
	private Date dateOfPayment;

	@Column(name = "date_of_order")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfOrder;

	@Column(name = "total")
	private float total;

	@Column(name= "shift")
	private String shift;

	@Column(name = "status")
	private boolean status;


	public Invoice(String code, Customer customer, List<Lobby> lobby, List<Food> food, Date dateOfPayment, Date dateOfOrder, int total, boolean status) {
		this.code = code;
		this.customer = customer;
		this.lobby = lobby;
		this.food = food;
		this.dateOfPayment = dateOfPayment;
		this.dateOfOrder = dateOfOrder;
		this.total = total;
		this.status = status;
	}

	public List<Service> getService() {
		return service;
	}

	public void setService(List<Service> service) {
		this.service = service;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public List<Lobby> getLobby() {
		return lobby;
	}

	public void setLobby(List<Lobby> lobby) {
		this.lobby = lobby;
	}

	public List<Food> getFood() {
		return food;
	}

	public void setFood(List<Food> food) {
		this.food = food;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Invoice() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
