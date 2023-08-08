package com.dit.models;

public class Company {
public String name,jobType,location;
public int ctc;
public double eligibility;
public String[] branches;

public Company(String name,String jobType,String location,int ctc,double eligibility, String[] branches){

	this.name=name;
	this.jobType=jobType;
	this.location=location;
	this.ctc=ctc;
	this.eligibility=eligibility ;
	this.branches=branches;
}
}
