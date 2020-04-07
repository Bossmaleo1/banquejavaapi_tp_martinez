package com.tnsi.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tnsi.bank.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{

}
