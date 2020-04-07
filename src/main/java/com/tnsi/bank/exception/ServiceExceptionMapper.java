package com.tnsi.bank.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.http.HttpStatus;

import com.tnsi.bank.model.ErrorMessage;

@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException>{

	@Override
	public Response toResponse(ServiceException ex) {
		
		/*
		 * // // TODO Auto-generated method stub // ErrorMessage error=new
		 * ErrorMessage(ex.getMessage(),ex.getStatusCode()); // return
		 * Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).entity(error).type(
		 * MediaType.APPLICATION_JSON) // .build();
		 */		 		 		 
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setHttpStatus(ex.getHttpStatus());
        errorMessage.setCode(ex.getCode());
        errorMessage.setMessage(ex.getMessage());
        StringWriter errorStackTrace = new StringWriter();
        ex.printStackTrace(new PrintWriter(errorStackTrace));
        errorMessage.setDeveloperMessage(ex.toString());
        return Response.status(ex.getHttpStatus()).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
  
	}

	

}
