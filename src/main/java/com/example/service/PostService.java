package com.example.service;

import java.util.List;

import com.example.dto.PostDto;

public interface PostService {
	
	public PostDto createPost(PostDto postDto);

	public void deletePost(int id);

	public List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortOrder);

	public PostDto updatePost(int postId, PostDto postDto);
}
