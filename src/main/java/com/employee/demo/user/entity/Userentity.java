package com.employee.demo.user.entity;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "mobile"))
public class Userentity {
	 @OneToMany//(mappedBy = "user", cascade = CascadeType.ALL)
	    private List<OrderEntity> orders;
	    
	    public List<OrderEntity> getOrders() {
			return orders;
		}

		public void setOrders(List<OrderEntity> orders) {
			this.orders = orders;
		}

		public String getUsername() {
			return username;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUserame() {
			return username;
		}

		public void setUsername(String  username) {
			this.username = username;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @Column(nullable = false, unique = true)
	    private String username;

	    private String address;

	    private String password;
	    @Column(nullable = false)
	    private String mobile;
	    
	    
		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

	
	}



