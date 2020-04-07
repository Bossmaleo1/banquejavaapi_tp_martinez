package com.tnsi.bank.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Compte {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idCompte;
	private String numero;
	private double solde;
	@OneToOne()
	private Client client;
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;
	
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(long idCompte, String numero, double solde, Client client, List<Operation> operations) {
		super();
		this.idCompte = idCompte;
		this.numero = numero;
		this.solde = solde;
		this.client = client;
		this.operations = operations;
	}
	public long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(long idCompte) {
		this.idCompte = idCompte;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	
	

}
