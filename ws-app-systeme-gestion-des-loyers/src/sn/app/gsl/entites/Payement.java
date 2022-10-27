package sn.app.gsl.entites;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payement {
	
	private int id;
	private String datePayement;
	private double montant;
	private String nomLocataire;
	private String prenomLocataire;
	private int idBI;
	
	
	public Payement() {
		
	}
	
	
	public Payement(String datePayement, double montant, String nomLocataire, String prenomLocataire, int idBI) {
		this.datePayement = datePayement;
		this.montant = montant;
		this.nomLocataire = nomLocataire;
		this.prenomLocataire = prenomLocataire;
		this.idBI = idBI;
	}



	public Payement(int id, String datePayement, double montant, String nomLocataire, String prenomLocataire, int idBI) {
		this(datePayement, montant, nomLocataire, prenomLocataire, idBI);
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
	public String getDatePayement() {
		return datePayement;
	}
	public void setDatePayement(String datePayement) {
		this.datePayement = datePayement;
	}



	@XmlElement
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}



	@XmlElement
	public String getNomLocataire() {
		return nomLocataire;
	}
	public void setNomLocataire(String nomLocataire) {
		this.nomLocataire = nomLocataire;
	}



	@XmlElement
	public String getPrenomLocataire() {
		return prenomLocataire;
	}
	public void setPrenomLocataire(String prenomLocataire) {
		this.prenomLocataire = prenomLocataire;
	}



	@XmlElement
	public int getIdBI() {
		return idBI;
	}
	public void setIdBI(int idBI) {
		this.idBI = idBI;
	}
	
	

	
	
	

}
