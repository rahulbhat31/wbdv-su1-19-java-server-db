package com.example.myapp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="courses")
public class Course { 
	@Id  
	   @GeneratedValue
	      (strategy=GenerationType.IDENTITY)
	   private int id;
	private String name;

	public Course() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Faculty getAuthor() {
		return author;
	}

	@ManyToOne()
	@JsonIgnore
	private Faculty author;
	
	public void setAuthor(Faculty author) {
		  this.author = author;
		  if(!author.getAuthoredCourses().contains(this)) {
		     author.getAuthoredCourses().add(this);
		}}
	@OneToMany(mappedBy="course" , orphanRemoval=true)
	private List<Module> includedmodules;
	
	public List<Module> getIncludedmodules() {
		return includedmodules;
	}
	public void setIncludedmodules(List<Module> Includedmodules) {
		this.includedmodules = includedmodules;
	}
	
	

	public void includedModulesfun(Module module)
	{    this.includedmodules.add(module);
	     if(module.getCourse() != this) {
	    	 module.setCourse(this);
	}}
	
}
