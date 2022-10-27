package sn.app.gsl.entites;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class Personne {
	private int id;
	private String nom;
	private String prenom;
	private String contact;
	private String email;
	private String dateNaissance;
	private String sexe;
	
	public Personne() {
		
	}

	
	public Personne(String nom, String prenom, String contact, String email, String dateNaissance, String sexe) {
		this.nom = nom;
		this.prenom = prenom;
		this.contact = contact;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
	}
	
	public Personne(int id, String nom, String prenom, String contact, String email, String dateNaissance, String sexe) {
		this(nom, prenom, contact, email, dateNaissance, sexe);
		this.id = id;
		
	}


	
	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@XmlElement
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@XmlElement
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement
	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String date) {
		this.dateNaissance = date;
	}

	@XmlElement
	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	

}
