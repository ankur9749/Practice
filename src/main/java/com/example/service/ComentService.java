package com.example.service;

import com.example.dto.ComentDto;

public interface ComentService {
	
	public ComentDto createComent(int postId, ComentDto comentDto);

}
