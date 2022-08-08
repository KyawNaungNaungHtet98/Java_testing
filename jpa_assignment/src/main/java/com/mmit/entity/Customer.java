package com.mmit.entity;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 *
 */
//@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	private String phone;

	@Enumerated(STRING)
	private Gender gender;
	
	@OneToOne
	private Users user;
	
	@ElementCollection
	@CollectionTable(
	name = "Photos",
	joinColumns = @JoinColumn(name = "customer_id")
	)
	@Column(name = "photo_name")
	private List<String> photo;
	public Customer() {
		super();
	}

	enum Gender {
		male, female

	}
}
