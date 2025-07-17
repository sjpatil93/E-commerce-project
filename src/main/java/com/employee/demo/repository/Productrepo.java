package com.employee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.demo.user.entity.ProductEntity;
@Repository
public interface Productrepo extends JpaRepository<ProductEntity, Long> {

}
