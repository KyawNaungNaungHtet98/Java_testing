package com.mmit.entity;

import static javax.persistence.CascadeType.PERSIST;

import java.io.Serializable;
import java.text.Format.Field;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Merchant
 *
 */
@Entity
@Table(name = "merchants")
public class Merchant implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "primary_phone", unique = true)
	private String primaryPhone;

	@Column(name = "secondary_phone")
	private String secondaryPhone;

	@Column(nullable = false, name = "shop_name")
	private String shopName;
	
	@Column(columnDefinition = "TEXT")
	private String address;
	
	
	@OneToOne(mappedBy = "merchant", cascade = PERSIST)
	private Users user;
	public Merchant() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrimaryPhone() {
		return primaryPhone;
	}
	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}
	public String getSecondaryPhone() {
		return secondaryPhone;
	}
	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}

}
