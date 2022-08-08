package com.mmit.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "shipping_address")
	private String shippingAddress;
	
	@Column(nullable = false, name = "shipping_phone")
	private String shippingPhone;
	
	private double total_amount;
	
	private LocalDate order_date;
	
	
	public Order() {
		super();
	}
   
}
