package com.tnsi.bank.model;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.GeneratedValue;

@Entity
public class Client {
	@GeneratedValue
	@Id
	private long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private Date dateNaissance;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nom, String prenom, String adresse, String codePostal, Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.dateNaissance = dateNaissance;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public void affiche() {
		System.out.println("Test");
	}
	
	

}
