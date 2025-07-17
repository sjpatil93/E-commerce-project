package com.employee.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.demo.repository.OrderRepo;
import com.employee.demo.user.entity.OrderEntity;

@Service
	public class OrderService {

	    @Autowired
	    private OrderRepo orderRepository;
	    
	   public OrderEntity addcart(OrderEntity addcart) {
		return orderRepository.save(addcart);
		   
	   }

	    public OrderEntity placeOrder(OrderEntity order) {
	    	
				return orderRepository.save(order);
			
	    }
	    public List<OrderEntity> getAllProducts() {
			return orderRepository.findAll();
		}

	    public OrderEntity updateOrderStatus(Long orderId, String status) {
	        OrderEntity order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
	        order.setStatus(status);
	        return orderRepository.save(order);
	    }
	    public String deleteorder(Long orderId) {
	    	if(orderRepository.existsById(orderId)) {
			 orderRepository.deleteById(orderId);
			 return "Order deleted successfully" + orderId;
			}else {
				return "Something went wrong"; 
			}
	    	
	    	
	    }


	

	}



