package com.mmit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float price;
	
	@OneToMany(mappedBy = "product")
	private List<OrderItem> orderItems;
	
	@ManyToOne
	private Category category;
	public Product() {
		super();
	}
   
}
