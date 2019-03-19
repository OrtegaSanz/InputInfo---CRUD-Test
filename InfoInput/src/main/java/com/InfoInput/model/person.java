package com.InfoInput.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class person implements Serializable{
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 2, max = 35, message = "Name is to short or to long")
	private String name;
	@Size(min = 2, max = 35, message = "Last name is to short or to long")
	private String lastname;
	private String birthday;
	@Size(min = 20, max = 100, message = "Address is not valid")
	private String address;
	@Range(min=930, message="Has to be greater than 930")
	private double salary;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
