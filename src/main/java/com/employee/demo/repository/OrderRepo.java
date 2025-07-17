package com.employee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.demo.user.entity.OrderEntity;
@Repository
public interface OrderRepo extends JpaRepository<OrderEntity,Long> {

	@SuppressWarnings("unchecked")
	OrderEntity save(OrderEntity order);

}
