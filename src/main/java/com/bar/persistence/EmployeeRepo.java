package com.bar.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
}
