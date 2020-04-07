package com.tnsi.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tnsi.bank.model.Client;
import com.tnsi.bank.repository.ClientRepository;

@Controller
public class MainController {
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/add") 
	public @ResponseBody String addNewClient(@RequestParam String nom, @RequestParam String prenom) {
		Client c=new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		clientRepository.save(c);
		return "Saved";
	}
	
	@GetMapping("/all")
	  public @ResponseBody Iterable<Client> getAllClients() {
	    // This returns a JSON or XML with the users
	    return clientRepository.findAll();
	  }

}
