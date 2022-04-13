package com.ipl_fantasy.utils;

public class UserNameAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameAlreadyExistException(String msg) {
		super(msg);
	}
}
