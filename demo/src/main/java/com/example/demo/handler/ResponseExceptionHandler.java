package com.example.demo.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.GeneralExceptionRs;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<GeneralExceptionRs> generalExceptionHandler(Exception e, WebRequest request) {
		GeneralExceptionRs er = new GeneralExceptionRs(LocalDateTime.now(), e.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<GeneralExceptionRs> notFoundExceptionHandler(NotFoundException e,
			WebRequest request) {
		GeneralExceptionRs er = new GeneralExceptionRs(LocalDateTime.now(), e.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
	}
}