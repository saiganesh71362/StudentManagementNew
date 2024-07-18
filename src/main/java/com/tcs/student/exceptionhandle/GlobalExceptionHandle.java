package com.tcs.student.exceptionhandle;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandle
{

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ExceptionMessage> handleStudentException(StudentNotFoundException studentNotFoundException, WebRequest webRequest)
	 {
		ExceptionMessage exception = new ExceptionMessage(new  Date(), studentNotFoundException.getMessage(),webRequest.getDescription(false) );
		
	  return new ResponseEntity<ExceptionMessage>(exception, HttpStatus.OK);
	 }
	
	

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ExceptionMessage> handleEntityNotFoundException(EntityNotFoundException enException, WebRequest webRequest)
	{
		ExceptionMessage exception = new ExceptionMessage(new Date(),enException.getMessage() , webRequest.getDescription(false));
		
		return new  ResponseEntity<ExceptionMessage>(exception, HttpStatus.OK);
	}
}
