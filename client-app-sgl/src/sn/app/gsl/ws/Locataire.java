
package sn.app.gsl.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour locataire complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="locataire">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.gsl.app.sn/}personne">
 *       &lt;sequence>
 *         &lt;element name="idBI" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numCIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "locataire", propOrder = {
    "idBI",
    "numCIN",
    "typeLocation"
})
public class Locataire
    extends Personne
{

    protected int idBI;
    protected String numCIN;
    protected String typeLocation;

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
     * Obtient la valeur de la propri�t� numCIN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCIN() {
        return numCIN;
    }

    /**
     * D�finit la valeur de la propri�t� numCIN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCIN(String value) {
        this.numCIN = value;
    }

    /**
     * Obtient la valeur de la propri�t� typeLocation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeLocation() {
        return typeLocation;
    }

    /**
     * D�finit la valeur de la propri�t� typeLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeLocation(String value) {
        this.typeLocation = value;
    }

}
