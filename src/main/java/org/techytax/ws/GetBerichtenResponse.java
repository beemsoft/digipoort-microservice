
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
 *         &lt;element name="getBerichtenReturn" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}ArrayOfBerichtResultaat"/>
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
    "getBerichtenReturn"
})
@XmlRootElement(name = "getBerichtenResponse")
public class GetBerichtenResponse {

    @XmlElement(required = true)
    protected ArrayOfBerichtResultaat getBerichtenReturn;

    /**
     * Gets the value of the getBerichtenReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBerichtResultaat }
     *     
     */
    public ArrayOfBerichtResultaat getGetBerichtenReturn() {
        return getBerichtenReturn;
    }

    /**
     * Sets the value of the getBerichtenReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBerichtResultaat }
     *     
     */
    public void setGetBerichtenReturn(ArrayOfBerichtResultaat value) {
        this.getBerichtenReturn = value;
    }

}
