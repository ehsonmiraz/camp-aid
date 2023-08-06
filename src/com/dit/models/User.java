package com.dit.models;

public class User {
    String sapId;
    String rollno;
    String name;
    double current_cgpa;
    int sem;
    int totalSem;
    String branch;
    
    
	public User(String sapId,String rollno,String name,double current_cgpa,int sem,int totalSem,String branch){
		this.sapId=sapId;
	    this.rollno=rollno;
	    this.name=name;
	    this.current_cgpa=current_cgpa;
	    this.sem=sem;
	    this.totalSem=totalSem;
	    this.branch=branch;
	}
	@Override
	public String toString() {
		return  this.sapId+ " | " +this.rollno + " | "+ this.name+ " | "
	            + this.current_cgpa+ " | "+ this.sem+ " | "+ this.totalSem+ " | "+ this.branch;
			
	}
}
