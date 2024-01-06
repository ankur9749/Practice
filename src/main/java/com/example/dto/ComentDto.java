package com.example.dto;

public class ComentDto {

	private int id;
	private String body;
	private String email;
	private String name;
	public ComentDto(int id, String body, String email, String name) {
		super();
		this.id = id;
		this.body = body;
		this.email = email;
		this.name = name;
	}
	public ComentDto() {
		super();
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
