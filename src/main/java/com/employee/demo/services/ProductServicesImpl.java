package com.employee.demo.services;

import java.io.IOException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employee.demo.repository.Productrepo;
import com.employee.demo.user.entity.ProductEntity;

@Service
public class ProductServicesImpl implements ProductServices {

	@Autowired
	private Productrepo productRepository;

	public ProductEntity save(ProductEntity product, MultipartFile file) {

		try {
			if (file != null && !file.isEmpty()) {
				product.setImage(file.getBytes());
			}
			return productRepository.save(product);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to store file.", e);
		}
}
		
	public ProductEntity updateProduct(Long id, ProductEntity productDetails) {
		Optional<ProductEntity> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			ProductEntity product = optionalProduct.get();
			product.setName(productDetails.getName());
			product.setAdmin(product.getAdmin());
			product.setImage(productDetails.getImage());
			return productRepository.save(product);
		}
		return null;
	}

	public List<ProductEntity> getAllProducts() {
		return productRepository.findAll();
	}

	public String deleteProduct(Long id) {
		productRepository.deleteById(id);
		return "Product deleted successfully!";
	}

	public Optional<ProductEntity> findById(Long id) {
		return productRepository.findById(id);
	}

	
	
	}

