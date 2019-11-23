package com.bar.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bar.model.Employee;
import com.bar.persistence.EmployeeDAO;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDAO dao;
	//Create
	public void addEmployee(Employee employee){
		dao.addEmployee(employee);
	}
	//Read
	public Optional<Employee> findEmployee(long id) {
		return dao.findEmployee(id);
	}
	public long countEntries() {
		return dao.countEntries();
	}
	public boolean existsById(long id) {
		return dao.existsById(id);
	}
	
	//Update
	public void updateEmployee(long id, Employee employee) {
		dao.updateEmployee(id, employee);
	}
	//Delete
	public void deleteEmployee(long id) {
		dao.deleteEmployee(id);
	}
}
