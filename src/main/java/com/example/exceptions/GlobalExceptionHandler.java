package com.example.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.dto.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourceNotFoundException(
			ResourceNotFoundException exception,
			WebRequest webRequest
			){
		ErrorDetails er = new ErrorDetails(new Date(), exception.getMessage(), 
				webRequest.getDescription(true));
		return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handelGlobalException(
			Exception exception,
			WebRequest webRequest
			){
		ErrorDetails er = new ErrorDetails(new Date(), exception.getMessage(), 
				webRequest.getDescription(true));
		return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
