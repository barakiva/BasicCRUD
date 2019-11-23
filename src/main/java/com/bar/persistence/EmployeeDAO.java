package com.bar.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bar.model.Employee;
@Component
public class EmployeeDAO {
	@Autowired
	private EmployeeRepo repo;
	//Create
	public void addEmployee(Employee employee){
		repo.save(employee);
	}
	//Read
	public Optional<Employee> findEmployee(long id) {
		return repo.findById(id);
	}
	public long countEntries() {
		return repo.count();
	}
	public boolean existsById(long id) {
		return repo.existsById(id);
	}
	//Update
	public void updateEmployee(long id , Employee employee) {
		Employee emp = repo.findById(id).get();
		if(employee.getFirst_name() != null) {
			emp.setFirst_name(employee.getFirst_name());
		}
		if(employee.getLast_name() != null) {
			emp.setLast_name(employee.getLast_name());
		}
		repo.save(emp);
	}

	public void deleteEmployee(long id) {
		repo.deleteById(id);
	}
	
}
