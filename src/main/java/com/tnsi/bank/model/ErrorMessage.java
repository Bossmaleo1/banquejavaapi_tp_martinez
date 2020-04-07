package com.tnsi.bank.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

//Cette classe sert pour transformer erreur en JSON
@XmlRootElement
public class ErrorMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2961034868620106457L;
	private int httpStatus;
	private String message;
	private int code;
	private String developerMessage;
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorMessage(int httpStatus, String message, int code, String developerMessage) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.code = code;
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
	public String getDeveloperMessage() {
		return developerMessage;
	}
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	
	
	
	
	
	
	
	
	
	

}
