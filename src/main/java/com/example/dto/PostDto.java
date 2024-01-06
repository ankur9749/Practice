package com.example.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PostDto {

	private int id;
	
	@NotEmpty
	@Size(min = 2, message = "Title should be atleast 2 characters")
	private String title;
	
	@NotEmpty
	@Size(min = 4, message = "Description should be atleast 4 characters")
	private String description;
	
	@NotEmpty
	@Size(min = 4, message = "Content should be atleast 4 characters")
	private String content;
	private String message;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public PostDto(int id, String title, String description, String content, String message) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.message = message;
	}
	public PostDto() {
		super();
	}
	
	
}
