package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.ComentDto;
import com.example.entity.Aentity;
import com.example.entity.Comment;
import com.example.exceptions.ResourceNotFoundException;
import com.example.repositry.PostRepository;
import com.example.service.ComentService;

@Service
public class ComentServiceImpl implements ComentService {
	
	@Autowired
	private ComentRepository rep;
	
	@Autowired
	private PostRepository repo;

	public ComentDto createComent(int postId, ComentDto comentDto) {
		Aentity or = repo.findById(postId).orElseThrow(
				()-> new ResourceNotFoundException("Post not found: "+postId));
		Comment com = new Comment();
		com.setName(comentDto.getName());
		com.setBody(comentDto.getBody());
		com.setEmail(comentDto.getEmail());
		
		com.setAentity(or);
		
		Comment saveComment = rep.save(com);
		
		ComentDto dto = new ComentDto();
		dto.setBody(saveComment.getBody());
		dto.setEmail(saveComment.getEmail());
		dto.setName(saveComment.getName());
		dto.setId(saveComment.getId());
		return dto;

	}
}
