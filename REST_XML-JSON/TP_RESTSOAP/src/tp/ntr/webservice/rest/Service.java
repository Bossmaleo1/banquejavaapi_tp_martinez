package tp.ntr.webservice.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Path("/")
public class Service {
	// Consultation Compte Bancaire BDD en JSON en fonction de l'id 
	// http://localhost:8080/TP_RESTSOAP/jsonConsulterCompteBancaireBDD/1
	@GET
    @Produces("application/json")
    @Path("/jsonConsulterCompteBancaireBDD/{AccountId}")
    public ClientCompte jsonCustomerAccountWithDB(@PathParam("AccountId") int AccountId) {
		DBConnection db = new DBConnection();
		Connection cn =null;
		Statement st =null;
		Statement stTransaction =null;
		ResultSet rs =null;
		ResultSet rsTransaction =null;
		ClientCompte compte = null;
		
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Etape 2 : r�cup�raion de la connexion
			cn = DriverManager.getConnection(db.getUrl(), db.getLogin(), db.getPasswd());

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();
			stTransaction = cn.createStatement();

			// RR�cup�rer Toutes les infos du client SAUF les transactions
			String sql = "SELECT * FROM Banque b, Compte cpt WHERE cpt.idBanque = b.idBanque AND cpt.idCompte = "+ AccountId;
			
 
			// Etape 4 : ex�cution de la requ�te 
			rs = st.executeQuery(sql);

			// Si donnees alors �tape 5 (parcours Resultat)

			while (rs.next()) {
				compte = new ClientCompte(rs.getInt("cpt.idCompte"),rs.getString("cpt.nom"),rs.getString("cpt.prenom"), rs.getString("cpt.adresse"), 
						rs.getInt("cpt.codePostal"),rs.getString("cpt.ville"), rs.getString("b.nom"), rs.getFloat("cpt.solde"), null);
				
				// OK 2e requ�tes pour les transactions
				int idCompte = rs.getInt("cpt.idCompte");
				String sqlTransaction = "SELECT * From Operation WHERE idCompteDebit = "+ idCompte + " OR idCompteCredit = " + idCompte + ";";
				rsTransaction = stTransaction.executeQuery(sqlTransaction);
				List<Transaction> transactionsAccount1 = new ArrayList<Transaction>();
				while (rsTransaction.next()) {
					//Transaction t = new Transaction(rsTransaction.getInt("idOperation"), rsTransaction.getDate("date"), rsTransaction.getFloat("debit"), rsTransaction.getFloat("credit") , rsTransaction.getString("nom"));
					Transaction t = new Transaction(rsTransaction.getInt("idOperation"), rsTransaction.getString("date"), rsTransaction.getFloat("somme"), rsTransaction.getInt("idCompteDebit"), rsTransaction.getInt("idCompteCredit"), rsTransaction.getString("nom"));
					transactionsAccount1.add(t);
				}
				compte.setTransaction(transactionsAccount1);		
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : lib�rer ressources de la m�moire.
				cn.close();
				st.close();
				stTransaction.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return compte;
	}


	@POST
	@Produces("application/xml")
	@Consumes("application/xml")
	@Path("ajoutOperationCompteXML")
	public Transaction creditAccountXML(Transaction transaction) {
		DBConnection db = new DBConnection();
		Connection cn =null;
		Statement st =null;
		ResultSet rs = null;
		String sql=null;
		
		String transactionDate  = transaction.getDate();
		int idCompteCredit = transaction.getIdCompteCredit();
		int idCompteDebit = transaction.getIdCompteDebit();
		float somme = transaction.getSomme();
		String transactionName = transaction.getTransactionName();
	
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(db.getUrl(), db.getLogin(), db.getPasswd());

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();
			
			// 1 ere requ�te ins�rer la transaction dans la table Operation
			sql = "INSERT INTO `Operation` (`nom`, `date`, `idCompteDebit`, `idCompteCredit`, `somme`) VALUES ('"+ transactionName +"', '"+ transactionDate +"', "+ idCompteDebit +", " + idCompteCredit + "," + somme +");";
			// Etape 4 : ex�cution requ�te
			st.executeUpdate(sql);
			
			// 2e requ�te credit montant dans la table du Compte Bancaire de la personne 
			sql = "UPDATE Compte SET solde=solde+"+ somme +" WHERE idCompte="+ idCompteCredit+";";
			st.executeUpdate(sql);
			
			// 3e requ�te debit montant dans la table du Compte Bancaire de la personne 
			sql = "UPDATE Compte SET solde=solde-"+ somme +" WHERE idCompte="+ idCompteDebit+";";
			st.executeUpdate(sql);
			
			// 4e requ�te le dernier id ajout�
			sql = "SELECT MAX(`idOperation`) AS idOperation FROM `Operation`";
			rs = st.executeQuery(sql);
			// Si r�cup donn�es alors �tapes 5 (parcours Resultat)
			while (rs.next()) {
				transaction.setTransactionId(rs.getInt("idOperation"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : lib�rer ressources de la m�moire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return transaction;
	} 
}
