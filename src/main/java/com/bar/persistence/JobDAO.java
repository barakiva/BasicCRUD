package com.bar.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bar.model.Job;

@Component
public class JobDAO {
	@Autowired
	private JobRepo repo;
	//Create
	public void addJob(Job job) {
		repo.save(job);
	}
	//Read
	public Job findJob(long id) {
		return repo.findById(id).get();
	}
	public long countEntries() {
		return repo.count();
	}
	//Update
	
	//Delete
	public void deleteJobById(long id) {
		repo.deleteById(id);
	}
}
