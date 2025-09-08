package com.nist.sms.controller;

public class Student {
	private int id;
	String name, address, email, faculty, phone, gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddres() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String Gender) {
		this.gender = Gender;
	}

}
