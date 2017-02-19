
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
 *         &lt;element name="getProcessenReturn" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}ArrayOfProcesResultaat"/>
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
    "getProcessenReturn"
})
@XmlRootElement(name = "getProcessenResponse")
public class GetProcessenResponse {

    @XmlElement(required = true)
    protected ArrayOfProcesResultaat getProcessenReturn;

    /**
     * Gets the value of the getProcessenReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProcesResultaat }
     *     
     */
    public ArrayOfProcesResultaat getGetProcessenReturn() {
        return getProcessenReturn;
    }

    /**
     * Sets the value of the getProcessenReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProcesResultaat }
     *     
     */
    public void setGetProcessenReturn(ArrayOfProcesResultaat value) {
        this.getProcessenReturn = value;
    }

}
