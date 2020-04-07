package com.tnsi.bank.exception;

import com.tnsi.bank.model.ErrorMessage;

public class ServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int httpStatus;
    private String message;
    private int code;
    private String developerMessage;
    
    public ServiceException(int httpStatus, String message, int code,String developerMessage) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.code = code;
        this.developerMessage=developerMessage;
    }
    
    
 
    public ServiceException(int httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}



	public ServiceException(int httpStatus, String message, int code) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.code = code;
    }
 
    public ServiceException(ErrorMessage errorMessage){
        this.httpStatus = errorMessage.getHttpStatus();
        this.message = errorMessage.getMessage();
        this.code = errorMessage.getCode();
        this.developerMessage=errorMessage.getDeveloperMessage();
    }
 
    public String getDeveloperMessage() {
        return developerMessage;
    }
 
    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
 
    public int getHttpStatus() {
        return httpStatus;
    }
 
    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public int getCode() {
        return code;
    }
 
    public void setCode(int code) {
        this.code = code;
    }
	

	
	
	

}
