package com.ujjwalsingh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.ujjwalsingh.annotation.UniqueUserName;

@Entity
public class Users {
	@Id
	@GeneratedValue
	private int id;
	@Size(min=2,message="Name should be atleast 2 characters")
	private String name;
	@Size(min=2,message="Address should be atleast 2 characters")
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		System.out.println("hello");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
