package com.employee.demo.user.entity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class ProductEntity {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}


		private String name;
	    
	    
	    private String price;
	    private String quantity;
	    private String description;
	    private String category;
	    
	    @Lob
	    @Column(columnDefinition = "LONGBLOB")
	    private byte[] image;
		
		
		
		
		public byte[] getImage() {
			return image;
		}
		public void setImage(byte[] image) {
			this.image = image;
		}
		/*
		 * public void setImage(String filename) { this.image = filename; }
		 */
		public ProductEntity(Long id, String name, String address, String mobile, String price, String quantity,
				String description, byte[] image) {
			super();
			this.id = id;
			this.name = name;
			
			this.price = price;
			this.quantity = quantity;
			this.description = description;
		}
		public ProductEntity() {
			super();
			// TODO Auto-generated constructor stub
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
		
		public AdminEntity getAdmin() {
			return admin;
		}
		public void setAdmin(AdminEntity admin) {
			this.admin = admin;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getQuantity() {
			return quantity;
		}
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	    
	   
		  @ManyToOne
		    @JoinColumn(name = "admin_id") // FK in Product Table
		    private AdminEntity admin;

	
		
		
	   
	}


