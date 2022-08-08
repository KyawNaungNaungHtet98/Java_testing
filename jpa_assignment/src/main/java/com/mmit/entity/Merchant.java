package com.mmit.entity;

import java.io.Serializable;
import java.text.Format.Field;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Merchant
 *
 */
//@Entity
@Table(name = "merchants")
public class Merchant implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "merchant_id")
	private int id;

	@Column(name = "primary_phone", unique = true)
	private String primaryPhone;

	@Column(name = "secondary_phone")
	private String secondaryPhone;

	@Column(nullable = false, name = "shop_name")
	private String shopName;
	
	@Column(columnDefinition = "TEXT")
	private String address;
	@OneToOne
	private Users user;
	public Merchant() {
		super();
	}

}
