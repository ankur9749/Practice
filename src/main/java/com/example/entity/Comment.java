package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String body;
	private String email;
	private String name;
	
	public Comment(int id, String body, String email, String name) {
		super();
		this.id = id;
		this.body = body;
		this.email = email;
		this.name = name;
	}
	
	public Comment() {
	}
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Aentity aentity;

	public Aentity getAentity() {
		return aentity;
	}

	public void setAentity(Aentity aentity) {
		this.aentity = aentity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
