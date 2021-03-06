package com.tnsi.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tnsi.bank.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
