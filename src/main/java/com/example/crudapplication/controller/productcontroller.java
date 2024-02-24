package com.example.crudapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudapplication.model.Product;
import com.example.crudapplication.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getproduct")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok().body(productService.getAllProducts());
	}
	
	@GetMapping("/getproductbyid/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		return ResponseEntity.ok().body(productService.getProductById(id));
	}
	
	@PostMapping("/createproduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.ok().body(this.productService.createProduct(product));
	}
	
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
		product.setId(id);
		return ResponseEntity.ok().body(this.productService.updateProduct(product));
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public HttpStatus deleteProduct(@PathVariable long id) {
		this.productService.deleteProduct(id);
		return HttpStatus.OK;
	}
}
