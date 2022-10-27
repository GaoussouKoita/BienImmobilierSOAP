
package sn.app.gsl.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour payement complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="payement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datePayement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idBI" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="montant" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="nomLocataire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenomLocataire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payement", propOrder = {
    "datePayement",
    "id",
    "idBI",
    "montant",
    "nomLocataire",
    "prenomLocataire"
})
public class Payement {

    protected String datePayement;
    protected int id;
    protected int idBI;
    protected double montant;
    protected String nomLocataire;
    protected String prenomLocataire;

    /**
     * Obtient la valeur de la propri�t� datePayement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatePayement() {
        return datePayement;
    }

    /**
     * D�finit la valeur de la propri�t� datePayement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatePayement(String value) {
        this.datePayement = value;
    }

    /**
     * Obtient la valeur de la propri�t� id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * D�finit la valeur de la propri�t� id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propri�t� idBI.
     * 
     */
    public int getIdBI() {
        return idBI;
    }

    /**
     * D�finit la valeur de la propri�t� idBI.
     * 
     */
    public void setIdBI(int value) {
        this.idBI = value;
    }

    /**
     * Obtient la valeur de la propri�t� montant.
     * 
     */
    public double getMontant() {
        return montant;
    }

    /**
     * D�finit la valeur de la propri�t� montant.
     * 
     */
    public void setMontant(double value) {
        this.montant = value;
    }

    /**
     * Obtient la valeur de la propri�t� nomLocataire.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomLocataire() {
        return nomLocataire;
    }

    /**
     * D�finit la valeur de la propri�t� nomLocataire.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomLocataire(String value) {
        this.nomLocataire = value;
    }

    /**
     * Obtient la valeur de la propri�t� prenomLocataire.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenomLocataire() {
        return prenomLocataire;
    }

    /**
     * D�finit la valeur de la propri�t� prenomLocataire.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenomLocataire(String value) {
        this.prenomLocataire = value;
    }

}
