
package sn.app.gsl.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ajouterBI complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ajouterBI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bienImmoblier" type="{http://ws.gsl.app.sn/}bienImmobilier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ajouterBI", propOrder = {
    "bienImmoblier"
})
public class AjouterBI {

    protected BienImmobilier bienImmoblier;

    /**
     * Obtient la valeur de la propriété bienImmoblier.
     * 
     * @return
     *     possible object is
     *     {@link BienImmobilier }
     *     
     */
    public BienImmobilier getBienImmoblier() {
        return bienImmoblier;
    }

    /**
     * Définit la valeur de la propriété bienImmoblier.
     * 
     * @param value
     *     allowed object is
     *     {@link BienImmobilier }
     *     
     */
    public void setBienImmoblier(BienImmobilier value) {
        this.bienImmoblier = value;
    }

}
