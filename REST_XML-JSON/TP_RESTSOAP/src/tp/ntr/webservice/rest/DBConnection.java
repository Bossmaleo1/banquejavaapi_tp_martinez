package tp.ntr.webservice.rest;

public class DBConnection {
	String url;
	String login;
	String passwd;
	
	DBConnection(){
		//  Accès à la BDD
		this.url = "jdbc:mysql://localhost:3306/TP_NTR_Banque_BDD?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		this.login = "root";
		this.passwd = "root";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
