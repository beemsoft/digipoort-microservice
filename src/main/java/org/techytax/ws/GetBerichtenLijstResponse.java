
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
 *         &lt;element name="getBerichtenLijstReturn" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}ArrayOfBerichtLijstResultaat"/>
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
    "getBerichtenLijstReturn"
})
@XmlRootElement(name = "getBerichtenLijstResponse")
public class GetBerichtenLijstResponse {

    @XmlElement(required = true)
    protected ArrayOfBerichtLijstResultaat getBerichtenLijstReturn;

    /**
     * Gets the value of the getBerichtenLijstReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBerichtLijstResultaat }
     *     
     */
    public ArrayOfBerichtLijstResultaat getGetBerichtenLijstReturn() {
        return getBerichtenLijstReturn;
    }

    /**
     * Sets the value of the getBerichtenLijstReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBerichtLijstResultaat }
     *     
     */
    public void setGetBerichtenLijstReturn(ArrayOfBerichtLijstResultaat value) {
        this.getBerichtenLijstReturn = value;
    }

}
