package com.example.demo.handler;

public class ServiceException extends Exception{

	private static final long serialVersionUID = -4928095995398397216L;

	public ServiceException() {
	}

	public ServiceException(String text, Exception e) {
		super(text, e);
	}

	public ServiceException(String text) {
		super(text);
	}


}
