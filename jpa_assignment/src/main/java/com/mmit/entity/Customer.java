package com.mmit.entity;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.EnumType.STRING;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	private String phone;

	@Enumerated(STRING)
	private Gender gender;
	
	
	@OneToOne(mappedBy = "customer", cascade = PERSIST)
	private Users user;
	
	@ElementCollection
	@CollectionTable(
	name = "Photos",
	joinColumns = @JoinColumn(name = "customer_id")
	)
	@Column(name = "photo_name")
	private List<String> photo;
	
	@OneToMany(mappedBy = "customer") 
	private List<Order> orders;
	
	public Customer() {
		super();
	}

	enum Gender {
		male, female

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<String> getPhoto() {
		return photo;
	}

	public void setPhoto(List<String> photo) {
		this.photo = photo;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
