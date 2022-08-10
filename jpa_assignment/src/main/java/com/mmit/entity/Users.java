package com.mmit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.AccessType.FIELD;
import static javax.persistence.AccessType.PROPERTY;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true, nullable = false, name = "username")
	private String userName;

	@Column(unique = true)
	private String email;
	@Column(nullable = false)
	private String password;

	private boolean is_active;

	@OneToOne
	@JoinColumn(name = "customer_id")
	@MapsId("id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "merchant_id")
	@MapsId("id")
	private Merchant merchant;
	public Users() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

}
