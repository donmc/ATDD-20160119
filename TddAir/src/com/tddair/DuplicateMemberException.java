package com.tddair;

public class DuplicateMemberException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DuplicateMemberException() { super(); }
	public DuplicateMemberException(String message) { super(message); }
	public DuplicateMemberException(String message, Throwable cause) { super(message, cause); }
	public DuplicateMemberException(Throwable cause) { super(cause); }
}
