package tp.ntr.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class MainRestJson {

	public static void main(String[] args) throws JSONException, IOException {
		

		
	    // Consulter Compte 1 AVEC bdd: 
	    JSONObject jsonCpt1 = consulterCompteBDD(1);
	    System.out.println("\nConsulter Compte 1 avec BDD : \n" + jsonCpt1);
	}
	

	public static JSONObject consulterCompteBDD(int idCompte) throws JSONException, IOException {
		// Initialiser le service Rest Json Pour consulter un compte avec base de donnees
	    String urlConsulterCompteBDD = "http://localhost:8080/TP_RESTSOAP/jsonConsulterCompteBancaireBDD/"+idCompte;
	    String res = null;
	    String output;
        URL url = new URL(urlConsulterCompteBDD);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        
        while ((output = br.readLine()) != null) {
        	res = output;
        }
        conn.disconnect();
        
		JSONObject jsonObj = new JSONObject(res);
		return jsonObj;
	}
}
	
	

