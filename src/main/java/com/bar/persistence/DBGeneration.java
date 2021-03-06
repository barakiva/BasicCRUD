package com.bar.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bar.model.Employee;
import com.bar.services.EmployeeService;
import com.github.javafaker.Faker;

@Component
public class DBGeneration {
	private Faker faker = new Faker();
	@Autowired
	private EmployeeService empService;
	
	public void createDB(long size) {
		for(int i = 0; i < size; i++) {
			Employee emp = new Employee();
			emp.setFirst_name(faker.name().firstName());
			emp.setLast_name(faker.name().lastName());
			empService.addEmployee(emp);
		}
	}
	
}
