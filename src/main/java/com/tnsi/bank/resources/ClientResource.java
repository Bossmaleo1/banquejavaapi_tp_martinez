package com.tnsi.bank.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tnsi.bank.exception.ServiceException;
import com.tnsi.bank.model.Client;
import com.tnsi.bank.repository.ClientRepository;

@Component
@Path("clients")
public class ClientResource {
	@Autowired
	private ClientRepository clientRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getClient() {
	    return clientRepository.findAll();
	}
	
	 @POST  
	 @Consumes(MediaType.APPLICATION_JSON) 
	 public Response createClient(Client client, @Context UriInfo uriInfo) throws ServiceException {
		 if ((client.getNom() == null || client.getNom().isEmpty()) ||
			(client.getPrenom() == null || client.getPrenom().isEmpty()) ||
			(client.getEmail() == null || client.getEmail().isEmpty()) 
			) {
			 	System.out.println("mandalo ato");
				throw new ServiceException(HttpStatus.BAD_REQUEST.value(),"Renseigner tous les champs obligatoires");

			} else {
				 client=clientRepository.save(client);
				 long id=client.getIdClient();
				 URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
			        return Response.created(createdUri)
			        		.entity("Client created")
			        		.build();
			}
	 }
		 
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Client getClient(@PathParam("id") Long id) throws ServiceException {
		Optional<Client> client=clientRepository.findById(id);
		return client.orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND.value(),"Client not found"));
	}
	
	@DELETE
	@Path("{id}")
	public Response  deleteStudent(@PathParam("id") Long id) throws ServiceException {
		clientRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.CONFLICT.value(),"Client not found"));
		clientRepository.deleteById(id);
		return Response.ok().build();
	   
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStudent(@PathParam("id") Long id, Client client) throws ServiceException {
		Client clientInDB = clientRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.CONFLICT.value(),"Client not found",1));
		clientInDB.setNom(client.getNom());
		clientInDB.setPrenom(client.getPrenom());
		clientInDB.setEmail(client.getEmail());
		clientRepository.save(clientInDB);
		return Response.ok(clientInDB).build();
	     
	         
	}
}
