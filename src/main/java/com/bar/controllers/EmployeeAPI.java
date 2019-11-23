package com.bar.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bar.model.Employee;
import com.bar.persistence.DBGeneration;
import com.bar.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeAPI {
	@Autowired
	private EmployeeService empService;
	@Autowired
	private DBGeneration dbGen;
	
	@PostConstruct
	public void initApi() {
		this.test();
	}
	
	@GetMapping("/init")
	public String test() {
		System.out.println("test alive");
		dbGen.createDB(100);
		return Long.toString(empService.countEntries());
	}

	@GetMapping("/count-entries")
	public String countEntries() {
		return Long.toString(empService.countEntries());
	}
	@PostMapping("/add-employee")
	public void addEmployee(@RequestParam("first_name") String first_name,
							@RequestParam("last_name") String last_name){

		empService.addEmployee(new Employee(first_name, last_name));
	}
	@GetMapping("/find-employee")
	public Employee findEmployee(@RequestParam("id") long id) {
		return empService.findEmployee(id).get();
	}
	@PostMapping("/update-employee")
	public void updateEmployee(@RequestParam("id") long id,
								@RequestParam(name = "first_name", required=false) String first_name,
								@RequestParam(name = "last_name", required=false) String last_name) {
		
		empService.updateEmployee(id, new Employee(first_name, last_name));
	}
	@DeleteMapping("/delete-employee")
	public String deleteEmployee(@RequestParam("id") long id) {
		empService.deleteEmployee(id);
		return "employee delete";
	}
}
