package com.pidi.resource.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pidi.servicies.exceptions.DataBaseException;
import com.pidi.servicies.exceptions.NotFoudExceptions;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(NotFoudExceptions.class)
	public ResponseEntity<StandardError> notFound(NotFoudExceptions e, HttpServletRequest request){
		String error = "Resource Not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error,e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBase(DataBaseException e, HttpServletRequest request){
		String error = "Data base error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(), error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
