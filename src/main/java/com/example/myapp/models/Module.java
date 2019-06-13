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
@Table(name="modules")
public class Module {
	@Id  
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public Module() {

	}
	@ManyToOne()
	@JsonIgnore
	private Course course;


	public Course getCourse() {
		return course;
	}
	public Module(String string) {
		this.title = string;
	}

	public void setCourse(Course course) {
		this.course = course;
		if(!course.getIncludedmodules().contains(this)) {
			course.getIncludedmodules().add(this);
		}}

	@OneToMany(mappedBy="module" , orphanRemoval=true)
	private List<Lesson> includedLessons;

	public List<Lesson> getIncludedLessons() {
		return includedLessons;
	}
	public void setIncludedLessons(List<Lesson> includedLessons) {
		this.includedLessons = includedLessons;
	}

	public void includedLessonfun(Lesson lesson)
	{    this.includedLessons.add(lesson);
	if(lesson.getModule() != this) {
		lesson.setModule(this);
	}}

}

