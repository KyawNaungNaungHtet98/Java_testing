package com.mmit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String content;
	
	@OneToMany(mappedBy = "category")
	private List<Product> product;
	public Category() {
		super();
	}
   
}
