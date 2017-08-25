package com.highcode.sms.exception;
import org.springframework.http.HttpStatus;

/**
 *  @author kedir yibrie 
 *
 */
public class GenericException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorDescription;
	private String errorCode;
	private HttpStatus httpStatusCode;

	/**
	 * 
	 */
	public GenericException() {
		super();
	}

	/**
	 * @param errorDescription
	 */
	public GenericException(String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
	}
	/**
	 * @param errorCode
	 * @param errorDescription
	 * @param httpStatusCode
	 */
	public GenericException(String errorCode, String errorDescription, HttpStatus httpStatusCode) {
		super(errorDescription);
		this.errorDescription = errorDescription;
		this.errorCode = errorCode;
		this.httpStatusCode = httpStatusCode;
	}
	/**
	 * @return errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}
	/**
	 * @param errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	/**
	 * @return serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	/**
	 * @return httpStatusCode
	 */
	public HttpStatus getHttpStatusCode() {
		return httpStatusCode;
	}

	/**
	 * @param httpStatusCode
	 */
	public void setHttpStatusCode(HttpStatus httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

}
