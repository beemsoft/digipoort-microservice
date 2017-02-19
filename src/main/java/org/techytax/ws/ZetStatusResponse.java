
package org.techytax.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="kenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}kenmerkType"/>
 *         &lt;element name="statuscode" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}statuscodeType"/>
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
    "kenmerk",
    "statuscode"
})
@XmlRootElement(name = "zetStatusResponse")
public class ZetStatusResponse {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String kenmerk;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String statuscode;

    /**
     * Gets the value of the kenmerk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKenmerk() {
        return kenmerk;
    }

    /**
     * Sets the value of the kenmerk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKenmerk(String value) {
        this.kenmerk = value;
    }

    /**
     * Gets the value of the statuscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatuscode() {
        return statuscode;
    }

    /**
     * Sets the value of the statuscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatuscode(String value) {
        this.statuscode = value;
    }

}
