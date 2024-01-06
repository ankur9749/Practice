package com.example.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ComentDto;
import com.example.service.ComentService;

@RestController
@RequestMapping("/api/coments")
public class ComentControler {
	
	@Autowired
	private ComentService ser;

	public ResponseEntity<ComentDto> createComment(@RequestParam int postId,
			@RequestBody ComentDto commentDto) {
		ser.createComent(postId, commentDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
