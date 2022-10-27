
package sn.app.gsl.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ajouterPayement complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ajouterPayement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="payement" type="{http://ws.gsl.app.sn/}payement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ajouterPayement", propOrder = {
    "payement"
})
public class AjouterPayement {

    protected Payement payement;

    /**
     * Obtient la valeur de la propriété payement.
     * 
     * @return
     *     possible object is
     *     {@link Payement }
     *     
     */
    public Payement getPayement() {
        return payement;
    }

    /**
     * Définit la valeur de la propriété payement.
     * 
     * @param value
     *     allowed object is
     *     {@link Payement }
     *     
     */
    public void setPayement(Payement value) {
        this.payement = value;
    }

}
