package com.employee;

import java.time.LocalDate;
import java.util.List;

public class Employee {

	int id;
	String name;
	Address address;
	LocalDate date;
	List skills;
	boolean isActive;
	
	
	
	public Employee(int id,String name,Address address,LocalDate date,List skills,boolean isActive) {
				
		this.id=id;
		this.name=name;
		this.address=address;
		this.date=date;
		this.skills=skills;
		this.isActive=isActive;
		
		
	}



	public int getId() {
		return id;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
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



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public List getSkills() {
		return skills;
	}



	public void setSkills(List skills) {
		this.skills = skills;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
