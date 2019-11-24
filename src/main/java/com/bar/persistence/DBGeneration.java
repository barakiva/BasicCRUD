package com.bar.persistence;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bar.model.Employee;
import com.bar.model.Job;
import com.bar.services.EmployeeService;
import com.github.javafaker.Faker;

@Component
public class DBGeneration {
	private Faker faker = new Faker();
	@Autowired
	private EmployeeService empService;
	private String[] jobDescriptions = {"debugging", "testing","customer service","biz dev"};
	
	public void createDB(long size) {
		for(int i = 0; i < size; i++) {
			Employee emp = new Employee();
			emp.setFirst_name(faker.name().firstName());
			emp.setLast_name(faker.name().lastName());
			empService.addEmployee(emp);
		}
	}
	private Job createJob() {
		int rand = (int) Math.random() * jobDescriptions.length;
		return new Job(jobDescriptions[rand], Calendar.getInstance(), Calendar.getInstance());
	}
	private List<Job> generateJobs(long amount){
		List<Job> jobList = new ArrayList<>();
		for(int i = 0; i < amount; i++) {
			jobList.add(createJob());
		}
		return jobList;
	}
	
}
