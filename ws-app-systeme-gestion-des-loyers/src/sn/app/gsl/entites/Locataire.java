package sn.app.gsl.entites;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Locataire extends Personne{

	private String numCIN;
	private String typeLocation;
	private int idBI;

	public Locataire() {
	}

	
	public Locataire(int id, String nom, String prenom, String contact, String email, String dateNaissance, String sexe,  String numCIN, String typeLocation, int idBI) {
		super(id, nom, prenom, contact, email, dateNaissance, sexe);
		this.numCIN = numCIN;
		this.typeLocation = typeLocation;
		this.idBI = idBI;		
	}
	public Locataire(String nom, String prenom, String contact, String email, String date, String sexe, String numCIN, String typeLocation, int idBI) {
		super(nom, prenom, contact, email, date, sexe);
		this.numCIN = numCIN;
		this.typeLocation = typeLocation;
		this.idBI = idBI;
	}


	@XmlElement
	public String getTypeLocation() {
		return typeLocation;
	}
	public void setTypeLocation(String typeLocation) {
		this.typeLocation = typeLocation;
	}


	@XmlElement
	public int getIdBI() {
		return idBI;
	}
	public void setIdBI(int idBI) {
		this.idBI = idBI;
	}


	@XmlElement
	public String getNumCIN() {
		return numCIN;
	}
	public void setNumCIN(String numCIN) {
		this.numCIN = numCIN;
	}

	

}
