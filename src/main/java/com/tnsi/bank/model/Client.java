package com.tnsi.bank.model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="clients")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idClient;
	
	@NotNull(message="Le nom est obligatoire")
	private String nom;
	@NotNull(message="Le prenom est obligatoire")
	private String prenom;
	@NotNull(message="L'adresse est obligatoire")
	private String adresse;
	@NotNull(message="L'email est obligatoire")
	private String email;
	private String motDePasse;
	
	@OneToOne(mappedBy = "client")
	private Compte compte;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Client(String nom, String prenom, String adresse, String email, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.motDePasse = motDePasse;
	}


	
	public long getIdClient() {
		return idClient;
	}


	public void setIdClient(long idClient) {
		this.idClient = idClient;
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
	
	
	public void affiche() {
		System.out.println("Test");
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
	
	

}
