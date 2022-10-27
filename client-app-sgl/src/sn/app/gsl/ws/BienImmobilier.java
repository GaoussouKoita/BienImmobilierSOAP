
package sn.app.gsl.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour bienImmobilier complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="bienImmobilier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="loyer" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="meuble" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nbrePiece" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeBI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bienImmobilier", propOrder = {
    "adresse",
    "details",
    "id",
    "loyer",
    "meuble",
    "nbrePiece",
    "status",
    "typeBI"
})
public class BienImmobilier {

    protected String adresse;
    protected String details;
    protected int id;
    protected double loyer;
    protected String meuble;
    protected int nbrePiece;
    protected String status;
    protected String typeBI;

    /**
     * Obtient la valeur de la propri�t� adresse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * D�finit la valeur de la propri�t� adresse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse(String value) {
        this.adresse = value;
    }

    /**
     * Obtient la valeur de la propri�t� details.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetails() {
        return details;
    }

    /**
     * D�finit la valeur de la propri�t� details.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetails(String value) {
        this.details = value;
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
     * Obtient la valeur de la propri�t� loyer.
     * 
     */
    public double getLoyer() {
        return loyer;
    }

    /**
     * D�finit la valeur de la propri�t� loyer.
     * 
     */
    public void setLoyer(double value) {
        this.loyer = value;
    }

    /**
     * Obtient la valeur de la propri�t� meuble.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeuble() {
        return meuble;
    }

    /**
     * D�finit la valeur de la propri�t� meuble.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeuble(String value) {
        this.meuble = value;
    }

    /**
     * Obtient la valeur de la propri�t� nbrePiece.
     * 
     */
    public int getNbrePiece() {
        return nbrePiece;
    }

    /**
     * D�finit la valeur de la propri�t� nbrePiece.
     * 
     */
    public void setNbrePiece(int value) {
        this.nbrePiece = value;
    }

    /**
     * Obtient la valeur de la propri�t� status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * D�finit la valeur de la propri�t� status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtient la valeur de la propri�t� typeBI.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeBI() {
        return typeBI;
    }

    /**
     * D�finit la valeur de la propri�t� typeBI.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeBI(String value) {
        this.typeBI = value;
    }

}
