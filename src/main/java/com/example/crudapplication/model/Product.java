package com.example.crudapplication.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

/**
 * Product entity with Lombok annotations for reduced boilerplate code.
 */
@Data  // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@Entity
@Table(name = "Products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String description;
	private BigDecimal price;

	@CreationTimestamp  // Automatically sets the createdAt field to the current date and time
	private Date createdAt;

	@UpdateTimestamp  // Automatically updates the updatedAt field to the current date and time
	private Date updatedAt;

	/**
	 * Constructor with all fields.
	 *
	 * @param id          The product ID
	 * @param name        The product name
	 * @param description The product description
	 * @param price       The product price
	 */
	public Product(long id, String name, String description, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	/**
	 * Default constructor.
	 */
	public Product() {
	}

}
