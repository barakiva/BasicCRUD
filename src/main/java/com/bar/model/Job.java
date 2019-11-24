package com.bar.model;

import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {
	@Id
	@GeneratedValue
	private long id;
	private String description;
	private LocalDateTime dueDate;
	private LocalDateTime startDate;
//	@ManyToOne(mappedBy="")
//	private long cart_id;
	public Job() {
		
	}
	public Job(String description, LocalDateTime dueDate, LocalDateTime startDate) {
		super();
		this.description = description;
		this.dueDate = dueDate;
		this.startDate = startDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public long getId() {
		return id;
	}
}
