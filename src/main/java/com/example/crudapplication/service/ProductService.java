package com.example.crudapplication.service;

import java.util.List;

import com.example.crudapplication.model.Product;

public interface ProductService {
	
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(long productId);
	public void deleteProduct(long productId); 
}
