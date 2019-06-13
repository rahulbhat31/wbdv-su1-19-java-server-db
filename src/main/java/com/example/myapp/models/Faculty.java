package com.example.myapp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Faculty extends User{
	@Id  
	   @GeneratedValue
	      (strategy=GenerationType.IDENTITY)
	   private int id;
	 private String office;
	  private Boolean tenure;
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Boolean getTenure() {
		return tenure;
	}
	public void setTenure(Boolean tenure) {
		this.tenure = tenure;
	}
	
	public List<Course> getAuthoredCourses() {
		return authoredCourses;
	}
	public void setAuthoredCourses(List<Course> authoredCourses) {
		this.authoredCourses = authoredCourses;
	}
	
	@OneToMany(mappedBy="author")
	private List<Course> authoredCourses;

	
	public Faculty(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}

	
	public Faculty() {
		
	}
	
	public void authoredCourse(Course course)
	{    this.authoredCourses.add(course);
	     if(course.getAuthor() != this) {
	        course.setAuthor(this);
	}}


}
