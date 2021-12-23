package com.example.demo.handler;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4381354321814449334L;

	public NotFoundException(String message) {
		super(message);
	}

}