package com.pidi.servicies.exceptions;

public class NotFoudExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoudExceptions(Object id) {
		super("Not Found id:" + id);
	}
}
