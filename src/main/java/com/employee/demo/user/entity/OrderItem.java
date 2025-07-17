package com.employee.demo.user.entity;

import jakarta.persistence.Embeddable;

@Embeddable
	public class OrderItem {
	    private String name;
	    public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public double getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}
		private String image;
	    private int quantity;
	    private double price;
	    private double totalPrice;

	    // Getters and Setters
	}



