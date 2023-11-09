package com.bellatrix.custumexception;

public class InvalidBrowserError extends Error {
	String msg;
	public InvalidBrowserError(String msg) {
		this.msg = msg;
	}
	public String getMassage() {
		return msg;
	}

}
