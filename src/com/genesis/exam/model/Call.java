package com.genesis.exam.model;

import java.util.Date;

public class Call {
	private Customer customer;
	private Boolean isDone;
	private String issue;
	private String resolution;
	private Date creationDate;
	private Date resolutionDate;
	private String escalationType;
	
	//TODO: Add other details of a call
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getResolutionDate() {
		return resolutionDate;
	}
	public void setResolutionDate(Date resolutionDate) {
		this.resolutionDate = resolutionDate;
	}
	public String getEscalationType() {
		return escalationType;
	}
	public void setEscalationType(String escalationType) {
		this.escalationType = escalationType;
	}	
}
