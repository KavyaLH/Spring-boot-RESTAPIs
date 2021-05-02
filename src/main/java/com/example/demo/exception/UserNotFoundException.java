package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 7782764000592070408L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
