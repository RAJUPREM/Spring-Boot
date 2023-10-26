package com.comjava.Entity;

public class Result {
	
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(String message) {
		super();
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Result [message=" + message + "]";
	}

}
