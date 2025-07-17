
package com.employee.demo.controller;

import com.employee.demo.services.ProductServicesImpl;
import com.employee.demo.user.entity.ProductEntity;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/saveproducts")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class ProductController {

	@Autowired
	private ProductServicesImpl productService;

	private boolean isAdminLoggedIn(HttpSession session) {
		return session.getAttribute("admin") != null;
	}

	@PostMapping("/add")
	public ResponseEntity<String> addProduct1(@RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("price") String price,
			@RequestParam("category") String category, @RequestParam("image") MultipartFile image) {
		ProductEntity product = new ProductEntity();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setCategory(category);
		productService.save(product, image);
		return ResponseEntity.ok("Product added successfully!");

	}
	@GetMapping("/all")
	public List<ProductEntity> getAllProducts() {
		return productService.getAllProducts();
	}
	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
	    Optional<ProductEntity> productOpt = productService.findById(id);

	    if (productOpt.isPresent()) {
	        byte[] imageBytes = productOpt.get().getImage();
	        return ResponseEntity.ok()
	                .header("Content-Type", "image/jpeg") // or image/png based on file type
	                .body(imageBytes);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}


	

	@PutMapping("/update/{id}")
	public String updateProduct(@PathVariable Long id, @RequestBody ProductEntity product, HttpSession session) {
		if (!isAdminLoggedIn(session))
			return "Unauthorized: Admin login required.";
		ProductEntity updated = productService.updateProduct(id, product);
		return updated != null ? "Product updated successfully!" : "Product not found!";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id, HttpSession session) {
		if (!isAdminLoggedIn(session))
			return "Unauthorized: Admin login required.";
		return productService.deleteProduct(id);
	}

	
}
