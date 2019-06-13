package com.example.myapp.models;
import javax.persistence.*;

@Entity
public class User {
   @Id  
   @GeneratedValue
      (strategy=GenerationType.IDENTITY)
   private int id;
	   private String username;
	   private String password;
	   private String firstName;
	   private String lastName;
	public User(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public User () {
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	}

