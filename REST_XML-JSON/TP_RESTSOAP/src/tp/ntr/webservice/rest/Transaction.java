package tp.ntr.webservice.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transaction {
	int transactionId;
	String date;
	float somme;
	int idCompteDebit;
	int idCompteCredit;
	String transactionName;
	
	Transaction(){
		
	}

	public Transaction(int transactionId, String date, float somme, int idCompteDebit, int idCompteCredit,
			String transactionName) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.somme = somme;
		this.idCompteDebit = idCompteDebit;
		this.idCompteCredit = idCompteCredit;
		this.transactionName = transactionName;
	}
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getSomme() {
		return somme;
	}

	public void setSomme(float somme) {
		this.somme = somme;
	}

	public int getIdCompteDebit() {
		return idCompteDebit;
	}

	public void setIdCompteDebit(int idCompteDebit) {
		this.idCompteDebit = idCompteDebit;
	}

	public int getIdCompteCredit() {
		return idCompteCredit;
	}

	public void setIdCompteCredit(int idCompteCredit) {
		this.idCompteCredit = idCompteCredit;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	
}