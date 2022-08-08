package com.mmit.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Deliveries
 *
 */
@Entity
@Table(name = "deliveries")
public class Deliveries implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "delivery_man", nullable = false, unique = true)
	private String deliveryMan;
	@Column(name = "delivery_date")
	private LocalDate deliveryDate;
	private boolean is_delivery;
	public Deliveries() {
		super();
	}
   
}
