package com.bar.persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bar.model.Employee;
import com.bar.model.Job;
import com.bar.services.EmployeeService;
import com.bar.services.JobService;
import com.github.javafaker.Faker;

@Component
public class DBGeneration {
	private Faker faker = new Faker();
	@Autowired
	private EmployeeService empService;
	@Autowired
	private JobService jobService;
	private String[] jobDescriptions = {"debugging", "testing","customer service","biz dev"};
	
	public void createDB(long size) {
		for(int i = 0; i < size; i++) {
			Employee emp = new Employee();
			emp.setFirst_name(faker.name().firstName());
			emp.setLast_name(faker.name().lastName());
			empService.addEmployee(emp);
			jobService.addJob(createJob());
		}
	}
	private Job createJob() {
		int rand = (int) Math.random() * jobDescriptions.length;
		return new Job(jobDescriptions[rand], 
				LocalDateTime.now(), LocalDateTime.now());
	}
	private List<Job> generateJobs(long amount){
		List<Job> jobList = new ArrayList<>();
		for(int i = 0; i < amount; i++) {
			jobList.add(createJob());
		}
		return jobList;
	}
	
}
