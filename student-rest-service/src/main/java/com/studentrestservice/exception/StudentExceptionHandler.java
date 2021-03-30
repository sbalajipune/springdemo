package com.studentrestservice.exception;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestController
@RestControllerAdvice
public class StudentExceptionHandler //extends ResponseEntityExceptionHandler
{
	@ExceptionHandler({StudentNotFoundException.class})
	public final ResponseEntity<FaultMessage> handleStudentNotFoundException(Exception ex, WebRequest request)
	{
		FaultMessage message = new FaultMessage(new Date(), ex.getMessage());
		return new ResponseEntity<FaultMessage>(message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public final ResponseEntity<FaultMessage> handleHttpRequestMethodNotSupportedException(Exception ex, WebRequest request)
	{
		FaultMessage message = new FaultMessage(new Date(), ex.getMessage());
		ResponseEntity<FaultMessage> responseEntity = new ResponseEntity<FaultMessage>(message, HttpStatus.METHOD_NOT_ALLOWED);
		return responseEntity;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<FaultMessage> handleHttpRequestMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request)
	{
		
		int length = ex.getBindingResult().getAllErrors().size();
		String errMessage = ex.getBindingResult().getAllErrors().get(length-1).getDefaultMessage();
		FaultMessage message = new FaultMessage(new Date(), errMessage);
		ResponseEntity<FaultMessage> responseEntity = new ResponseEntity<FaultMessage>(message, HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<FaultMessage> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request)
	{
		FaultMessage message = new FaultMessage(new Date(), ex.getMessage());
		ResponseEntity<FaultMessage> responseEntity = new ResponseEntity<FaultMessage>(message, HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
}
