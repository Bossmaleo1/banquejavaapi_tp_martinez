package com.tnsi.bank.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.tnsi.bank.exception.GenericExceptionMapper;
import com.tnsi.bank.exception.ServiceExceptionMapper;
import com.tnsi.bank.resources.ClientResource;


@Configuration
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
        register(ClientResource.class);
        register(ServiceExceptionMapper.class);
        register(GenericExceptionMapper.class);
    }

}
