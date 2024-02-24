package com.example.crudapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudapplication.exception.ResourceNotFoundException;
import com.example.crudapplication.model.Product;
import com.example.crudapplication.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> productDb = this.productRepository.findById(product.getId());
		if(productDb.isPresent()) {
			Product productUpdate = productDb.get();
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
			productUpdate.setDescription(product.getDescription());
			productRepository.save(productUpdate);
			return productUpdate;
		}
		else {
			throw new ResourceNotFoundException("Record not found for id: " + product.getId());
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}

	@Override
	public Product getProductById(long productId) {
		Optional<Product> productDb = this.productRepository.findById(productId);
		if(productDb.isPresent()) {
			return productDb.get();
		}
		else {
			throw new ResourceNotFoundException("Record not found for id: " + productId);
		}
	}

	@Override
	public void deleteProduct(long productId) {
		Optional<Product> productDb = this.productRepository.findById(productId);
		if(productDb.isPresent()) {
			this.productRepository.delete(productDb.get());
		}
		else {
			throw new ResourceNotFoundException("Record not found for id: " + productId);
		}
	}

}
