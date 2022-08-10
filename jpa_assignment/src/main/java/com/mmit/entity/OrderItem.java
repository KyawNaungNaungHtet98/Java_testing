package com.mmit.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: OrderItem
 *
 */
@Entity
@Table(name = "order_items")
	public class OrderItem implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int subqty;
	@ManyToOne
	private Order orders;
	
	@ManyToOne
	private Product product;
	private static final long serialVersionUID = 1L;

	public OrderItem() {
		super();
	}
   
}
