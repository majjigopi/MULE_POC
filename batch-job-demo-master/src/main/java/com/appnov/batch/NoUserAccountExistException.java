package com.appnov.batch;


/**
 * 
 * @author Fattouh
 *
 */
public class NoUserAccountExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoUserAccountExistException() {
	}

	public NoUserAccountExistException(String message) {
		super(message);
	}

	public NoUserAccountExistException(Throwable cause) {
		super(cause);
	}

	public NoUserAccountExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoUserAccountExistException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
	}

}
