package org.elis.ecommerce.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.elis.ecommerce.dto.response.MessageDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class Handler {
	
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<MessageDto> erroreDB(SQLIntegrityConstraintViolationException e){
		MessageDto m=new MessageDto(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
	}
	
	@ExceptionHandler(DatiNonValidiException.class)
	public ResponseEntity<MessageDto> erroreDati(DatiNonValidiException e){
		MessageDto m=new MessageDto(e.getMessage(), HttpStatus.BAD_REQUEST.value(),e.getRequest());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
	}
	
	@ExceptionHandler(DatiNonTrovatiException.class)
	public ResponseEntity<MessageDto> erroreDati(DatiNonTrovatiException e){
		MessageDto m=new MessageDto(e.getMessage(), HttpStatus.BAD_REQUEST.value(),e.getRequest());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessageDto> gestoreDatiNonValidi(MethodArgumentNotValidException ex){
		Map<String,String> map=ex.getBindingResult()
		//List<String> errori=ex.getBindingResult()
			.getFieldErrors()
			.stream()
//			.map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
			.collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
	MessageDto me=new MessageDto(HttpStatus.BAD_REQUEST.value(),map);
	return ResponseEntity.badRequest().body(me);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<MessageDto> gestoreDatiNonValidi(ConstraintViolationException ex){
	Map<String,String> map=ex.getConstraintViolations().stream()
			.collect(Collectors.toMap(e->e.getPropertyPath().toString(), e->e.getMessage()));
	MessageDto me=new MessageDto(HttpStatus.BAD_REQUEST.value(),map);
	return ResponseEntity.badRequest().body(me);
	}
}