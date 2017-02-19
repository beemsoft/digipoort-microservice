
package org.techytax.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getNieuweBerichtenLijstReturn" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}ArrayOfBerichtLijstResultaat"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getNieuweBerichtenLijstReturn"
})
@XmlRootElement(name = "getNieuweBerichtenLijstResponse")
public class GetNieuweBerichtenLijstResponse {

    @XmlElement(required = true)
    protected ArrayOfBerichtLijstResultaat getNieuweBerichtenLijstReturn;

    /**
     * Gets the value of the getNieuweBerichtenLijstReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBerichtLijstResultaat }
     *     
     */
    public ArrayOfBerichtLijstResultaat getGetNieuweBerichtenLijstReturn() {
        return getNieuweBerichtenLijstReturn;
    }

    /**
     * Sets the value of the getNieuweBerichtenLijstReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBerichtLijstResultaat }
     *     
     */
    public void setGetNieuweBerichtenLijstReturn(ArrayOfBerichtLijstResultaat value) {
        this.getNieuweBerichtenLijstReturn = value;
    }

}
