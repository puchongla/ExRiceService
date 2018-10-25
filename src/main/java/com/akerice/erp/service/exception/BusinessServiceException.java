package com.akerice.erp.service.exception;

public class BusinessServiceException extends Exception {

private static final long serialVersionUID = 7718828512143293558L;
	
	private final String code;

	public BusinessServiceException(String code) {
		super();
		this.code = code;
	}

	public BusinessServiceException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public BusinessServiceException(String message, String code) {
		super(message);
		this.code = code;
	}

	public BusinessServiceException(Throwable cause, String code) {
		super(cause);
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}

}
