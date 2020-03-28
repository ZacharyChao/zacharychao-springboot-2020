package com.zacharychao.myspringboot.exception;

public class MyException extends Exception {
	private long code;
	private String msg;

	public MyException(Long code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public MyException(String msg) {
		super(msg);
		this.msg = msg;
	}

}
