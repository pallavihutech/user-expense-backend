package com.hutech.userexpenseinfo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String id;
	String name;
	String email;
	String password;
	
	public Login(String id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;

	}

	public String getID() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Login() {
		super();
	}
}
