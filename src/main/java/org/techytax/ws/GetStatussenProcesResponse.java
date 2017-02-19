
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
 *         &lt;element name="getStatussenProcesReturn" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}ArrayOfStatusResultaat"/>
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
    "getStatussenProcesReturn"
})
@XmlRootElement(name = "getStatussenProcesResponse")
public class GetStatussenProcesResponse {

    @XmlElement(required = true)
    protected ArrayOfStatusResultaat getStatussenProcesReturn;

    /**
     * Gets the value of the getStatussenProcesReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfStatusResultaat }
     *     
     */
    public ArrayOfStatusResultaat getGetStatussenProcesReturn() {
        return getStatussenProcesReturn;
    }

    /**
     * Sets the value of the getStatussenProcesReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfStatusResultaat }
     *     
     */
    public void setGetStatussenProcesReturn(ArrayOfStatusResultaat value) {
        this.getStatussenProcesReturn = value;
    }

}
