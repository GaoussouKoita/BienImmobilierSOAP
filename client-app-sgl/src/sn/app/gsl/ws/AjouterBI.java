
package sn.app.gsl.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ajouterBI complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� bienImmoblier.
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
     * D�finit la valeur de la propri�t� bienImmoblier.
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
