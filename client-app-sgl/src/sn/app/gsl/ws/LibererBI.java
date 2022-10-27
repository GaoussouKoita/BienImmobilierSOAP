
package sn.app.gsl.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour libererBI complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="libererBI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idBI" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idLoc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "libererBI", propOrder = {
    "idBI",
    "idLoc"
})
public class LibererBI {

    protected int idBI;
    protected int idLoc;

    /**
     * Obtient la valeur de la propriété idBI.
     * 
     */
    public int getIdBI() {
        return idBI;
    }

    /**
     * Définit la valeur de la propriété idBI.
     * 
     */
    public void setIdBI(int value) {
        this.idBI = value;
    }

    /**
     * Obtient la valeur de la propriété idLoc.
     * 
     */
    public int getIdLoc() {
        return idLoc;
    }

    /**
     * Définit la valeur de la propriété idLoc.
     * 
     */
    public void setIdLoc(int value) {
        this.idLoc = value;
    }

}
