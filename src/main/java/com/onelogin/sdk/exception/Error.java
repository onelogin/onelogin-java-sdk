package com.onelogin.sdk.exception;


public class Error extends Exception {

	private static final long serialVersionUID = 1L;

	public static final int SETTINGS_FILE_NOT_FOUND = 1;

	private int errorCode;

	public Error(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public Error(String message) {
		super(message);
	}

    public int getErrorCode() {
        return errorCode;
    }

}