package com.example.crudapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudapplication.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
