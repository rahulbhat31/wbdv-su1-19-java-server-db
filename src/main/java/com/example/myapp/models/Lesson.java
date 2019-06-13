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
@Table(name="lessons")
public class Lesson {
	@Id  
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	private String title;

	public String getTitle() {
		return title;
	}

	public Lesson() {
	}
	public Lesson(String string) {
		this.title = string;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@ManyToOne()
	@JsonIgnore
	private Module module;


	public Module getModule() {
		return module;
	}


	public void setModule(Module module) {
		this.module = module;
		if(!module.getIncludedLessons().contains(this)) {
			module.getIncludedLessons().add(this);
		}}

	@OneToMany(mappedBy="lesson" , orphanRemoval=true)
	private List<Topic> includedTopics;

	public List<Topic> getIncludedTopics() {
		return includedTopics;
	}
	public void setIncludedTopics(List<Topic> includedLessons) {
		this.includedTopics = includedTopics;
	}

	public void includedTopicfun(Topic topic)
	{    this.includedTopics.add(topic);
	if(topic.getLesson() != this) {
		topic.setLesson(this);
	}}


}
