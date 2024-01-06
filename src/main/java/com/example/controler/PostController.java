package com.example.controler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PostDto;
import com.example.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@PostMapping
	public ResponseEntity<?> createPost(@Valid @RequestBody 
			PostDto postDto, BindingResult br) {
		if(br.hasErrors()) {
			return new ResponseEntity<>(br.getFieldError().getDefaultMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		PostDto createPost = postService.createPost(postDto);

		return new ResponseEntity<>(createPost, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		postService.deletePost(id);
		return ResponseEntity.status(HttpStatus.OK).body("Post has been deleated");
	}
	
	//http://localhost:8080/api/posts?pageNo=0&pageSize=5&sortBy=description&sortOrder=DESC
	
	@GetMapping
	public ResponseEntity<List<PostDto>> getAllPost(
			@RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(name = "pageSize", defaultValue = "3", required = false) int pageSize,
			@RequestParam(name = "sortBy", defaultValue = "id", required = false) String sortBy,
			@RequestParam(name = "sortOrder", defaultValue = "asc", required = false) String sortOrder
			) {
		List<PostDto> allPost = postService.getAllPost(pageNo, pageSize, sortBy, sortOrder);
		return new ResponseEntity<>(allPost, HttpStatus.OK);
	}
	
	//http://localhost:8080/api/posts?postId=1
	
	@PutMapping
	public ResponseEntity<PostDto> update(
			@RequestParam("postId") int postId,
			@RequestBody PostDto postDto) {
		PostDto up = postService.updatePost(postId, postDto);
		return new ResponseEntity<>(up, HttpStatus.OK);
	}
}
