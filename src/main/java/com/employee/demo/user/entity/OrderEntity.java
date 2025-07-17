package com.employee.demo.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderEntity {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	@ManyToOne
	@JoinColumn(name = "totalOrders", referencedColumnName = "id") // this is the foreign key column in 'Order' table
	private Userentity user;

	public Userentity getUser() {
		return user;
	}

	public void setUser(Userentity user) {
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public OrderEntity(Userentity user, Long id, String customerName, String customerAddress, String customerMobile,
			String productName, String price, String quantity, String status) {
		super();
		this.user = user;
		this.id = id;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerMobile = customerMobile;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}

	private String customerName;

	public OrderEntity(Userentity user, Long id, String customerName, String customerAddress, String customerMobile,
			String productName, String price, String quantity) {
		super();
		this.user = user;
		this.id = id;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerMobile = customerMobile;
		this.productName = productName;
		this.price = price;

	}

	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String customerAddress;
	private String customerMobile;
	private String productName;
	private String price;
	private String quantity;
	private String status = "Pending";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	// Getters and Setters
}
