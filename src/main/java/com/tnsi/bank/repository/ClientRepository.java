package com.tnsi.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.tnsi.bank.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{

}
