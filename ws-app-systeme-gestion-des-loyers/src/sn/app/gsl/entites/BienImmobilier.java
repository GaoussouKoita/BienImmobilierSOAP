package sn.app.gsl.entites;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BienImmobilier {
	private int id;
	private String adresse;
	private double loyer;
	private int nbrePiece;
	private String details;
	private String meuble;
	private String typeBI;
	private String status;
	
	
	

	public BienImmobilier() {
		
	}
	
	public BienImmobilier(String adresse, double loyer, int nbrePiece, String details, String meuble, String typeBI,  String status) {
		this.adresse = adresse;
		this.loyer = loyer;
		this.nbrePiece = nbrePiece;
		this.details = details;
		this.meuble = meuble;
		this.typeBI = typeBI;
		this.status = status;
	}
	
	

	public BienImmobilier(int id, String adresse, double loyer, int nbrePiece, String details, String meuble, String typeBI,  String status) {
		this(adresse, loyer, nbrePiece, details, meuble, typeBI, status);
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
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	@XmlElement
	public double getLoyer() {
		return loyer;
	}

	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}


	@XmlElement
	public int getNbrePiece() {
		return nbrePiece;
	}

	public void setNbrePiece(int nbrePiece) {
		this.nbrePiece = nbrePiece;
	}


	@XmlElement
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@XmlElement
	public String getMeuble() {
		return meuble;
	}

	public void setMeuble(String meuble) {
		this.meuble = meuble;
	}


	@XmlElement
	public String getTypeBI() {
		return typeBI;
	}

	public void setTypeBI(String typeBI) {
		this.typeBI = typeBI;
	}	
	

	@XmlElement
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
