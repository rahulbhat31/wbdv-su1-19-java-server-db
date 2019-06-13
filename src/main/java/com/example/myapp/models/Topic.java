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
@Table(name="topics")
public class Topic {

	@Id  
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;

	
	private String title;

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title =  title;
	}
	
	public Topic () {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne()
	@JsonIgnore
	private Lesson lesson;


	public Lesson getLesson() {
		return lesson;
	}

	public Topic(String string) {
		this.title = string;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
		if(!lesson.getIncludedTopics().contains(this)) {
			lesson.getIncludedTopics().add(this);
		}}

	@OneToMany(mappedBy="topic")
	private List<Widget> includedWidgets;

	public List<Widget> getIncludedWidgets() {
		return includedWidgets;
	}
	public void setIncludedWidgets(List<Widget> includedWidgets) {
		this.includedWidgets = includedWidgets;
	}

	public void includedWidgetfun(Widget widget)
	{    
		this.includedWidgets.add(widget);
		if(widget.getTopic() != this) {
			widget.setTopic(this);
		
		}}


}
