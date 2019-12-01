package com.bar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private String first_name;
	private String last_name;
	private int[] num_arr;
	public Employee() {
		super();
	}
	
	public Employee(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public long getId() {
		return id;
	}

	public int[] getNum_arr() {
		return num_arr;
	}

	public void setNum_arr(int[] num_arr) {
		this.num_arr = num_arr;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
