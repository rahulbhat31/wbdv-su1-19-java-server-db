package com.example.myapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student extends User {
	@Id  
	   @GeneratedValue
	      (strategy=GenerationType.IDENTITY)
	   private int id;
  private float gpa;
  private int graduationYear;
  public Student(String username, String password, String firstName, String lastName) {
	super(username, password, firstName, lastName);
  }
  
  public Student() {
	  
  }

public float getGpa() {
	return gpa;
}

public void setGpa(float gpa) {
	this.gpa = gpa;
}

public int getGraduationYear() {
	return graduationYear;
}

public void setGraduationYear(int graduationYear) {
	this.graduationYear = graduationYear;
}

  

}
