package com.wf.bootapp.ibs.exception;

public class SameCardPinException extends RuntimeException {
	public SameCardPinException(String message) {
		super(message);
	}
}
