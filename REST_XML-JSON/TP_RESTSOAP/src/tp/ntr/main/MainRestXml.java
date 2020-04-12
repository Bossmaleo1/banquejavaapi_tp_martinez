package tp.ntr.main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class MainRestXml {
	
	public static void main(String[] args) throws JSONException, IOException {
		
		System.out.println("Solde du Compte 1 et 3 AVANT dÃ©bit : ");
	
		// On consulte les soldes des comptes 1 et 3 avant et après le débit :
	    JSONObject jsonCpt1 =  MainRestJson.consulterCompteBDD(1);
	    JSONObject jsonCpt3 = MainRestJson.consulterCompteBDD(3);
	    System.out.println("Solde Compte 1 : " + jsonCpt1.get("balance") + " euros");
	    System.out.println("Solde Compte 3 : " + jsonCpt3.get("balance") + " euros");
	    
	    // On debite
	    System.out.println("\nReponse apres avoir debiter le compte 1 de 30euros vers le compte 3 : \n" +debitCreditCompte(1,3));
	    
	    System.out.println("\nSolde du Compte 1 et 3 APRES debit : ");
	    
	    // On affiche les soldes des comptes 1 et 3 apres debits
	    JSONObject jsonCpt1ApresDebit = MainRestJson.consulterCompteBDD(1);
	    JSONObject jsonCpt3ApresDebit = MainRestJson.consulterCompteBDD(3);
	    System.out.println("Solde Compte 1 : " + jsonCpt1ApresDebit.get("balance") + " euros");
	    System.out.println("Solde Compte 3 : " + jsonCpt3ApresDebit.get("balance") + " euros");
	}

	public static String debitCreditCompte(int compteDebit, int compteCredit) {
		// Initialiser le service Rest XML Pour debiter le compte  
	    String urlCrediterCompteBDD = "http://localhost:8080/TP_RESTSOAP/ajoutOperationCompteXML";
	    StringBuffer response=null;
	    try {

            URL url = new URL(urlCrediterCompteBDD);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/xml; charset=utf-8");
			 String xml = "<transaction>\n" + 
			 		"			<date>2019-02-11</date>\n" + 
			 		"			<idCompteCredit>"+compteCredit+"</idCompteCredit>\n" + 
			 		"    		<idCompteDebit>"+compteDebit+"</idCompteDebit>\n" + 
			 		"			<somme>30</somme>\n" + 
			 		"			<transactionName>Achat Amazon</transactionName>\n" + 
			 		"		</transaction>";
			 conn.setDoOutput(true);
			 DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			 wr.writeBytes(xml);
			 wr.flush();
			 wr.close();
			 BufferedReader in = new BufferedReader(new InputStreamReader(
			 conn.getInputStream()));
			 String inputLine;
			 response = new StringBuffer();
			 while ((inputLine = in.readLine()) != null) {
				 response.append(inputLine);
			 }
			 in.close();
		 } 
		 catch (Exception e) {
			 System.out.println(e);
		 }
		return response.toString();
	}
}
