
package sn.app.gsl.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour affecterBI complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="affecterBI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="locataire" type="{http://ws.gsl.app.sn/}locataire" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "affecterBI", propOrder = {
    "locataire"
})
public class AffecterBI {

    protected Locataire locataire;

    /**
     * Obtient la valeur de la propriété locataire.
     * 
     * @return
     *     possible object is
     *     {@link Locataire }
     *     
     */
    public Locataire getLocataire() {
        return locataire;
    }

    /**
     * Définit la valeur de la propriété locataire.
     * 
     * @param value
     *     allowed object is
     *     {@link Locataire }
     *     
     */
    public void setLocataire(Locataire value) {
        this.locataire = value;
    }

}
