package com.srinathji.shopngback.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_detail")
public class User {
	
	/*
	 * 
	 * CREATE TABLE user_detail (
 	id IDENTITY,
 	first_name VARCHAR(50),
 	last_name VARCHAR(50),
 	role VARCHAR(20),
 	enabled BOOLEAN,
 	contact_number int,
 	email VARCHAR(100),
 	password varchar(50),
	CONSTRAINT pk_user_detail_id PRIMARY KEY(id)	
); */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String role;
	private boolean enabled;
	@Column(name="contact_number")
	private String mobile;
	private String email;
	private String password;

	
	public User() {
		
	}

	public User(String firstName, String lastName, String role, boolean enabled, String mobile, String email,
			String password) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.enabled = enabled;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

}
