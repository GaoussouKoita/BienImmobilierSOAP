package sn.app.gsl.entites;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User extends Personne{

	private String adresse;
	private String login;
	private String password;
	private String typeCompte; 

	
	public User() {
	}
	
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}


	public User(String nom, String prenom, String contact, String email, 
			String date,String sexe, String adresse, String login, String password, String typeCompte) {
	
		super(nom, prenom, contact, email, date, sexe);
		this.adresse = adresse;
		this.login = login;
		this.password = password;
		this.typeCompte = typeCompte;
		
		
	}
	
	
	public User(int id, String nom, String prenom, String contact, String email, String dateNaissance,String  sexe, String adresse,  String login, String password, String typeCompte) {
		super(id, nom, prenom, contact, email, dateNaissance, sexe);
		this.adresse = adresse;
		this.login = login;
		this.password = password;
		this.typeCompte = typeCompte;
		
		
	}


	@XmlElement
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	@XmlElement
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@XmlElement
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@XmlElement
	public String getTypeCompte() {
		return typeCompte;
	}


	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	
	
	
	
}
