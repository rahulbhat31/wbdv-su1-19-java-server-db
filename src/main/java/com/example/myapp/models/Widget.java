package com.example.myapp.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="widgets")
public class Widget {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name="type")
	private String type;
	
	//Heading Widget & Para widget
	private String text;
	private int size;
	
	//Image Widget
	private String src;
	
	//Link Widget
	private String href;
	private String title;
	private String cssClass;
	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}




	//ListWidget
	private String items;
	
	private int order_no;
	
	public int getOrder() {
		return order_no;
	}
	
	public void setOrder(int order) {
		this.order_no = order;
	}
	
	
	
	
	@ManyToOne
	@JsonIgnore
	private Topic topic;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Widget() {
		
	}
	
//	public Widget(int id, String name, String type, String text, int size, String title, String href, int choice, String items, String src, int order) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.type = type;
//		this.text = text;
//		this.size = size;
//		this.title = title;
//		this.choice = choice;
//		this.items = items;
//		this.href = href;
//		this.src = src;
//		this.order_no = order;
//	}
//	
//	public Widget(Widget w) {
//		this.id = w.getId();
//		this.name = w.getName();
//		this.type = w.getType();
//	}
	
	public Topic getTopic() {
		return this.topic;
	}
	
	public void setTopic(Topic topic) {
		this.topic = topic;
		if(!topic.getIncludedWidgets().contains(this)) {
			topic.getIncludedWidgets().add(this);
		}
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	
	
}
