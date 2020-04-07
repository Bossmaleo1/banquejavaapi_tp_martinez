package com.tnsi.bank.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="operation")
public class Operation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idOperation;
	private String description;
	@ManyToOne
	private Compte compte;
	@Enumerated
	private TypeOperation type;
	private double montant;
	private Date dateOperation;
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(long idOperation) {
		this.idOperation = idOperation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public TypeOperation getType() {
		return type;
	}
	public void setType(TypeOperation type) {
		this.type = type;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	
	
	

}
