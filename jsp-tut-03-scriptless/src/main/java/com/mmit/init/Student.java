package com.mmit.init;

import java.time.LocalDate;

public class Student {
	private String name;
	private String phone;
	private String email;
	private LocalDate registerDate;
	private boolean old_student;
	private String batch;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	public boolean isOld_student() {
		return old_student;
	}
	public void setOld_student(boolean old_student) {
		this.old_student = old_student;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	
}
