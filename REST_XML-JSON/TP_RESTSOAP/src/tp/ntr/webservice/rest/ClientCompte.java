package tp.ntr.webservice.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClientCompte {

		int accountId;
		String lastName;
		String firstName;
		String adresse;
		int cp;
		String ville;
		String bank;
		float balance;
		List<Transaction> transaction;
		
		ClientCompte(){
			
		}

		public ClientCompte(int accountId, String lastName, String firstName, String adresse, int cp, String ville,
				String bank, float balance, List<Transaction> transaction) {
			super();
			this.accountId = accountId;
			this.lastName = lastName;
			this.firstName = firstName;
			this.adresse = adresse;
			this.cp = cp;
			this.ville = ville;
			this.bank = bank;
			this.balance = balance;
			this.transaction = transaction;
		}

		public int getAccountId() {
			return accountId;
		}

		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public int getCp() {
			return cp;
		}

		public void setCp(int cp) {
			this.cp = cp;
		}

		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public String getBank() {
			return bank;
		}

		public void setBank(String bank) {
			this.bank = bank;
		}

		public float getBalance() {
			return balance;
		}

		public void setBalance(float balance) {
			this.balance = balance;
		}

		public List<Transaction> getTransaction() {
			return transaction;
		}

		public void setTransaction(List<Transaction> transaction) {
			this.transaction = transaction;
		}


}
