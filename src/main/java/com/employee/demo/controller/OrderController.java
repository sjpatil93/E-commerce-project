package com.employee.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.employee.demo.services.OrderService;
import com.employee.demo.user.entity.OrderEntity;
import com.employee.demo.user.entity.ProductEntity;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class OrderController {

	@Autowired
	private OrderService orderService;

	private boolean isUserLoggedIn(HttpSession session) {
		return session.getAttribute("user") != null;
	}

	@PostMapping("/addcart")
	public String addcart(@RequestBody OrderEntity addcart, HttpSession session) {
		if (!isUserLoggedIn(session)) {
			return "Unauthorized: User login required.";
		}

		orderService.addcart(addcart);
		return "Product added ";
	}
	/*
	 * @PostMapping("/order") public ResponseEntity<String> placeOrder(@RequestParam
	 * ("name") String customerName,
	 * 
	 * @RequestParam("mobile") String customerMobile, @RequestParam("address")
	 * String customerAddress,
	 * 
	 * @RequestParam("item") String orderItem, @RequestParam("image1") MultipartFile
	 * image1) { OrderEntity order = new OrderEntity();
	 * order.setCustomerAddress(customerAddress);
	 * order.setCustomerMobile(customerMobile); order.setCustomerName(customerName);
	 * orderService.save(order, image1); return
	 * ResponseEntity.ok("Product added successfully!");
	 * 
	 * }
	 */

	@PostMapping("/orders")
    public String placeOrder(@RequestBody OrderEntity order, HttpSession session) {
        if (!isUserLoggedIn(session)) {
            return "Unauthorized: User login required.";
        }
        orderService.placeOrder(order);
        return "Order placed successfully!";
    }


	@GetMapping("/allorders")
	public List<OrderEntity> getAllProducts() {
		return orderService.getAllProducts();
	}
	// Admin confirms the order
	@PutMapping("/updateOrderStatus/{orderId}")
	public String updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
	    orderService.updateOrderStatus(orderId, status);
	    return "Order status updated successfully!";
	}
	@DeleteMapping("/delete/{orderId}")
	public String deleteorder(@PathVariable Long orderId) {
		orderService.deleteorder(orderId);
		return " order deleted successfully";
		
	}

}
