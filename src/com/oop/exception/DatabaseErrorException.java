package com.oop.exception;

public class DatabaseErrorException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DatabaseErrorException(String string, Exception e) {

		super(string,e);
	}

}