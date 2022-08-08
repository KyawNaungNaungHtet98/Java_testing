package com.mmit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Users
 *
 */
//@Entity

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

	public Users() {
		super();
	}

}
